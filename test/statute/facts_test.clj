(ns statute.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest cub-has-spec-basis
  (let [sb (facts/spec-basis "CUB")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["CUB" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= #{"cub.ley-118-inversion-extranjera" "cub.decreto-ley-226-registro-mercantil"}
         (set (mapv :statute/id (facts/by-topic "CUB" :corporate-governance)))))
  (is (= #{"cub.ley-118-inversion-extranjera" "cub.ley-116-codigo-trabajo"}
         (set (mapv :statute/id (facts/by-topic "CUB" :labor))))
      "Ley 118 Art.27/Art.8 of the Código de Trabajo cross-reference each other -- both tagged :labor")
  (is (empty? (facts/by-topic "ATL" :labor))))
