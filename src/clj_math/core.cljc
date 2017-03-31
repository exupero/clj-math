(ns clj-math.core)

(def abs #?(:clj #(Math/abs %) :cljs js/Math.abs))
(def acos #?(:clj #(Math/acos %) :cljs js/Math.acos))
(def acosh #?(:clj #(Math/log (+ % (Math/sqrt (dec (Math/pow % 2))))) :cljs js/Math.acosh))
(def asin #?(:clj #(Math/asin %) :cljs js/Math.asin))
(def asinh #?(:clj #(if (#{Double/NEGATIVE_INFINITY Float/NEGATIVE_INFINITY} %)
                      % (Math/log (+ % (Math/sqrt (inc (Math/pow % 2))))))
              :cljs js/Math.asinh))

(defn atan
  ([x]
   #?(:clj (Math/atan x) :cljs (js/Math.atan x)))
  ([x y]
   #?(:clj (Math/atan2 y x) :cljs (js/Math.atan2 y x))))

(def atanh #?(:clj #(/ (Math/log (/ (inc %) (- 1 %))) 2) :cljs js/Math.atanh))
(def cbrt #?(:clj #(Math/cbrt %) :cljs js/Math.cbrt))
(def ceil #?(:clj #(Math/ceil %) :cljs js/Math.ceil))
(def cos #?(:clj #(Math/cos %) :cljs js/Math.cos))
(def cosh #?(:clj #(Math/cosh %) :cljs js/Math.cosh))
(def exp #?(:clj #(Math/exp %) :cljs js/Math.exp))
(def expm1 #?(:clj #(Math/expm1 %) :cljs js/Math.expm1))
(def floor #?(:clj #(Math/floor %) :cljs js/Math.floor))
(def hypot #?(:clj #(Math/hypot %1 %2) :cljs js/Math.hypot))
(def log #?(:clj #(Math/log %) :cljs js/Math.log))
(def log1p #?(:clj #(Math/log1p %) :cljs js/Math.log1p))
(def log10 #?(:clj #(Math/log10 %) :cljs js/Math.log10))
(def log2 #?(:clj #(/ (log %) (log 2)) :cljs js/Math.log2))
(def pow #?(:clj #(Math/pow %1 %2) :cljs js/Math.pow))

(defn round
  ([x]
   #?(:clj (Math/round x) :cljs (js/Math.round x)))
  ([x precision]
   (* precision (round (/ x precision)))))

(def sign #?(:clj #(Math/signum %) :cljs js/Math.sign))
(def sin #?(:clj #(Math/sin %) :cljs js/Math.sin))
(def sinh #?(:clj #(Math/sinh %) :cljs js/Math.sinh))
(def sqrt #?(:clj #(Math/sqrt %) :cljs js/Math.sqrt))
(def tan #?(:clj #(Math/tan %) :cljs js/Math.tan))
(def tanh #?(:clj #(Math/tanh %) :cljs js/Math.tanh))

(def sqr #(pow % 2))

(def e #?(:clj Math/E :cljs js/Math.E))
(def ln2 #?(:clj (log 2) :cljs js/Math.LN2))
(def ln10 #?(:clj (log 10) :cljs js/Math.LN10))
(def log2e #?(:clj (/ (log Math/E) (log 2)) :cljs js/Math.LOG2E))
(def pi #?(:clj Math/PI :cljs js/Math.PI))
(def sqrt-half #?(:clj (Math/sqrt (/ 1 2)) :cljs js/Math.SQRT1_2))
(def sqrt-2 #?(:clj (Math/sqrt 2) :cljs js/Math.SQRT2))
