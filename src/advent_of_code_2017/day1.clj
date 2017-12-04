(ns advent-of-code-2017.day1)

(defn to-digits
  [captcha]
  (map #(Integer. (str %)) captcha))

(defn sum-matching-digits
  ([digits] (sum-matching-digits 0 (last digits) digits))
  ([sum prev digits]
   (let [new-sum
         (if (= prev (first digits))
           (+ sum prev)
           sum)]
     (if (> (count digits) 0)
       (recur new-sum (first digits) (rest digits))
       sum))))

(defn solve-first
  [captcha]
  (sum-matching-digits
   (to-digits captcha)))

(defn sum-matching-pairs
  ([pairs] (sum-matching-pairs 0 pairs))
  ([sum pairs]
   (let [pair (first pairs)
         new-sum
         (if (= (first pair) (second pair))
           (+ sum (* 2 (first pair)))
           sum)]
     (if (> (count pairs) 1)
       (recur new-sum (rest pairs))
       new-sum))))

(defn solve-second
  [captcha]
  (let [digits (to-digits captcha)
        [front tail] (split-at (/ (count digits) 2) digits)]
    (sum-matching-pairs (map list front tail))))
