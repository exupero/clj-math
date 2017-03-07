(ns clj-math.core)

(def e #?(:cljs js/Math.E))
(def ln2 #?(:cljs js/Math.LN2))
(def ln10 #?(:cljs js/Math.LN10))
(def log2e #?(:cljs js/Math.LOG2E))
(def pi #?(:cljs js/Math.PI))
(def sqrt-half #?(:cljs js/Math.SQRT1_2))
(def sqrt-2 #?(:cljs js/Math.SQRT2))

(def abs #?(:cljs js/Math.abs))
(def acos #?(:cljs js/Math.acos))
(def acosh #?(:cljs js/Math.acosh))
(def asin #?(:cljs js/Math.asin))
(def asinh #?(:cljs js/Math.asinh))

(defn atan
  ([x]
   #?(:cljs (js/Math.atan x)))
  ([x y]
   #?(:cljs (js/Math.atan2 y x))))

(def atanh #?(:cljs js/Math.atanh))
(def cbrt #?(:cljs js/Math.cbrt))
(def ceil #?(:cljs js/Math.ceil))
(def cos #?(:cljs js/Math.cos))
(def cosh #?(:cljs js/Math.cosh))
(def exp #?(:cljs js/Math.exp))
(def expm1 #?(:cljs js/Math.expm1))
(def floor #?(:cljs js/Math.floor))
(def hypot #?(:cljs js/Math.hypot))
(def log #?(:cljs js/Math.log))
(def log1p #?(:cljs js/Math.log1p))
(def log10 #?(:cljs js/Math.log10))
(def log2 #?(:cljs js/Math.log2))
(def pow #?(:cljs js/Math.pow))

(defn round
  ([x]
   #?(:cljs (js/Math.round x)))
  ([x precision]
   (* precision (round (/ x precision)))))

(def sign #?(:cljs js/Math.sign))
(def sin #?(:cljs js/Math.sin))
(def sinh #?(:cljs js/Math.sinh))
(def sqrt #?(:cljs js/Math.sqrt))
(def tan #?(:cljs js/Math.tan))
(def tanh #?(:cljs js/Math.tanh))

(def sqr #(pow % 2))
