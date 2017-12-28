(ns math.random
  (:require [rand-cljc.core :as rng]
            [math.core :as core])
  #?(:clj  (:import [java.util Random])
     :cljs (:import [goog.testing PseudoRandom])))

(defprotocol IGaussian
  (-gaussian [this]))

(defn next-gaussian [rng]
  (-gaussian rng))

#?(:clj
    (extend-type Random
      IGaussian
      (-guassian [this]
        (.nextGaussian this)))
   :cljs
    (extend-type PseudoRandom
      IGaussian
      (-gaussian [this]
        (if-let [g (.-nextGaussian this)]
          (do (set! (.-nextGaussian this) nil) g)
          (loop []
            (let [v1 (- (* 2 (rng/rand this)) 1)
                  v2 (- (* 2 (rng/rand this)) 1)
                  s (+ (* v1 v1) (* v2 v2))]
              (if (or (>= s 1) (zero? s))
                (recur)
                (let [mult (core/sqrt (* -2 (/ (core/log s) s)))]
                  (set! (.-nextGaussian this) (* mult v2))
                  (* mult v1)))))))))

(defn random-normal [rng mean stdev]
  (+ mean (* stddev (next-gaussian rng))))

(defn random-power-law [rng [x0 x1] n]
  (fn []
    (let [n+1 (inc n)
          x0-to-n+1 (core/pow x0 n+1)]
      (-> x1
        (core/pow n+1)
        (- x0-to-n+1)
        (* (rng/rand rng))
        (+ x0-to-n+1)
        (core/pow (/ n+1))))))

(defn gaussian-density [mean stdev]
  (let [double-variance (* 2 stdev stdev)
        coeff (/ (core/sqrt (* core/pi double-variance)))]
    #(* coeff (core/exp (- (/ (core/pow (- % mean) 2) double-variance))))))
