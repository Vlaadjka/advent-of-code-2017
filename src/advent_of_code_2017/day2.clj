(ns advent-of-code-2017.day2
  (:require [clojure.string :refer [split]]))

(defn to-cells
  [row]
  (map #(Integer. (str %)) (split row #"\s+")))

(defn to-rows
  [spreadsheet]
  (split spreadsheet #"\n"))

(defn row-difference
  [row]
  (let [cells (to-cells row)]
    (- (apply max cells)
       (apply min cells))))

(defn calculate-checksum
  [input]
  (apply + (map row-difference (to-rows input))))

(defn evenly-divisible-result
  [row]
  (let [numbers (to-cells row)]
    (reduce-kv
     (fn [r k v]
       (let [evenly-divisible (filter #(and (not= v %)
                                            (integer? (/ v %)))
                                      numbers)]
         (if (empty? evenly-divisible)
           r
           (/ v (first evenly-divisible)))))
     0
     (vec numbers))))

(defn calculate-evenly-divisible-checksum
  [input]
  (apply + (map evenly-divisible-result (to-rows input))))
