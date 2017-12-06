(ns advent-of-code-2017.day2-test
  (:require [advent-of-code-2017.day2 :refer :all]
            [clojure.test :refer :all]))

(deftest test-solution
  (is (= 18 (calculate-checksum "5 1 9 5\n7 5 3\n2 4 6 8")))

  (is (= 9 (calculate-evenly-divisible-checksum "5 9 2 8\n9 4 7 3\n3 8 6 5"))))
