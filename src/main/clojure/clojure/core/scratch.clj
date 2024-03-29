(ns clojure.core.match.test.scratch
 (:require [clojure.core.match :refer [match]]))


(require '[clojure.core.match :refer [match]])



(try
  (cond
    (= y false) (try
                  (cond (= z true) 1
                        :else (throw backtrack))
                  (catch Exception e
                    (if (identical? e backtrack)
                      (throw backtrack)
                      (throw e))))
    
    :else (throw backtrack))
  (catch Exception e
    (if (identical? e backtrack)
      (do
        (try
          (cond
            (= y true) (try (cond
                              (= x false) 2
                              :else (throw backtrack))
                            (catch Exception e
                              (if (identical? e backtrack)
                                (throw backtrack)
                                (throw e))))
            :else (throw backtrack))
          (catch Exception e
            (if (identical? e backtrack)
              (do (try
                    (cond
                      (= z false) 3
                      :else (trhow backtrack))
                    (catch  Exception e
                      (if (identical? e backtrack)
                        (do (try
                              (cond
                                (= z true) 4
                                :else (throw backtrack))
                              (catch Exception e
                                (if (identical? e backtrack)
                                  (throw no-matching-e)
                                  (throw e)))))
                        (throw e)))))
              (throw e)))))
      (throw e))))

;; this should be

(cond (= y false)  (cond (= z true) 1)
      (= y true) (cond (= x false) 2
                       (= z false) 3
                       (= z true) 4))



; loop + jump table (via case) | not cond? 










(let [v [1 2]]
  (clojure.core.match/match [v]
    [] [3 1] :a0
    [([1 a] :as b)] [:a1 a b]))

(let [y '(+ 1 3)
      z true]
  (match [(+ 1 3) y z]
         [false ([1] :seq) true ] 1
         [true true _ ] 2))

(let*
 [y '(+ 1 3) z true]
 (let*
  [ocr-15480 (+ 1 3) y y z z]
  (try
   (if
    (clojure.core/= ocr-15480 false)
    (try
     (if
      (let*
       [and__4467__auto__
        (let*
         [or__4469__auto__ (clojure.core/seq? y)]
         (if
          or__4469__auto__
          or__4469__auto__
          (clojure.core/sequential? y)))]
       (if and__4467__auto__ (clojure.core/seq y) and__4467__auto__))
      (try
       (let*
        [y_head__15485 (clojure.core/first y)]
        (if
         (clojure.core/= y_head__15485 1)
         (try
       ff   (let*
           [y_tail__15486 (clojure.core/rest y)]
           (if
            (clojure.core/empty? y_tail__15486)
            (try
             (if
              (clojure.core/= z true)
              1
              (if :else (throw clojure.core.match/backtrack) nil))
             (catch
              Exception
              e__14590__auto__
              (if
               (clojure.core/identical?
                e__14590__auto__
                clojure.core.match/backtrack
)
               (do (throw clojure.core.match/backtrack))
               (throw e__14590__auto__))))
            (if :else (throw clojure.core.match/backtrack) nil)))
          (catch
           Exception
           e__14590__auto__
           (if
            (clojure.core/identical?
             e__14590__auto__
             clojure.core.match/backtrack)
            (do (throw clojure.core.match/backtrack))
            (throw e__14590__auto__))))
         (if :else (throw clojure.core.match/backtrack) nil)))
       (catch
        Exception
        e__14590__auto__
        (if
         (clojure.core/identical?
          e__14590__auto__
          clojure.core.match/backtrack)
         (do (throw clojure.core.match/backtrack))
         (throw e__14590__auto__))))
      (if :else (throw clojure.core.match/backtrack) nil))
     (catch
      Exception
      e__14590__auto__
      (if
       (clojure.core/identical?
        e__14590__auto__
        clojure.core.match/backtrack)
       (do
        (try
         (if

          (clojure.core/= y true)
          2
          (if :else (throw clojure.core.match/backtrack) nil))
         (catch
          Exception
          e__14590__auto__
          (if
           (clojure.core/identical?
            e__14590__auto__
            clojure.core.match/backtrack)
           (do (throw clojure.core.match/backtrack))
           (throw e__14590__auto__)))))
       (throw e__14590__auto__))))
    (if :else (throw clojure.core.match/backtrack) nil))
   (catch
    Exception
    e__14590__auto__
    (if
     (clojure.core/identical?
      e__14590__auto__
      clojure.core.match/backtrack)
     (do
      (throw
       (new
        java.lang.IllegalArgumentException
        (clojure.core/str
         "No matching clause: "
         ocr-15480
         " "
         y
         " "
         z))))
     (throw e__14590__auto__))))))






(let*
 [ocr-15543 'x ocr-15544 'y ocr-15545 'z]
 (try
  (clojure.core/cond
   (clojure.core/= ocr-15544 false)
   (try
    (clojure.core/cond
     (clojure.core/= ocr-15545 true)
     1
     :else
     (throw clojure.core.match/backtrack))
    (catch
     Exception
     e__14592__auto__
     (if
      (clojure.core/identical?
       e__14592__auto__
       clojure.core.match/backtrack)
      (do (throw clojure.core.match/backtrack))
      (throw e__14592__auto__))))
   :else
   (throw clojure.core.match/backtrack))
  (catch
   Exception
   e__14592__auto__
   (if
    (clojure.core/identical?
     e__14592__auto__
     clojure.core.match/backtrack)
    (do
     (try
      (clojure.core/cond
       (clojure.core/= ocr-15544 true)
       (try
        (clojure.core/cond
         (clojure.core/= ocr-15543 false)
         2
         :else
         (throw clojure.core.match/backtrack))
        (catch
         Exception
         e__14592__auto__
         (if
          (clojure.core/identical?
           e__14592__auto__

           clojure.core.match/backtrack)
          (do (throw clojure.core.match/backtrack))
          (throw e__14592__auto__))))
       :else
       (throw clojure.core.match/backtrack))
      (catch
       Exception
       e__14592__auto__
       (if
        (clojure.core/identical?
         e__14592__auto__
         clojure.core.match/backtrack)
        (do
         (try
          (clojure.core/cond
           (clojure.core/= ocr-15545 false)
           3
           :else
           (throw clojure.core.match/backtrack))
          (catch
           Exception
           e__14592__auto__
           (if
            (clojure.core/identical?
             e__14592__auto__
             clojure.core.match/backtrack)
            (do
             (try
              (clojure.core/cond
               (clojure.core/= ocr-15545 true)
               4
               :else
               (throw clojure.core.match/backtrack))
              (catch
               Exception
               e__14592__auto__
               (if
                (clojure.core/identical?
                 e__14592__auto__
                 clojure.core.match/backtrack)
                (do
                 (throw
                  (java.lang.IllegalArgumentException.
                   (clojure.core/str
                    "No matching clause: "
                    ocr-15543
                    " "
                    ocr-15544
                    " "
                    ocr-15545))))
                (throw e__14592__auto__)))))
            (throw e__14592__auto__)))))
        (throw e__14592__auto__)))))
    (throw e__14592__auto__)))))











;------------------------------




(let*
 [ocr-15543 'x ocr-15544 'y ocr-15545 'z]
 (try
  (clojure.core/cond
   (clojure.core/= y false)
   (try
    (clojure.core/cond
     (clojure.core/= z true)
     1
     :else
     (throw clojure.core.match/backtrack))
    (catch
     Exception
     e__14592__auto__
     (if
      (clojure.core/identical?
       e__14592__auto__
       clojure.core.match/backtrack)
      (do (throw clojure.core.match/backtrack))
      (throw e__14592__auto__))))
   :else
   (throw clojure.core.match/backtrack))
  (catch
   Exception
   e__14592__auto__
   (if
    (clojure.core/identical?
     e__14592__auto__
     clojure.core.match/backtrack)
    (do
     (try
      (clojure.core/cond
       (clojure.core/= y true)
       (try
        (clojure.core/cond
         (clojure.core/= x false)
         2
         :else
         (throw clojure.core.match/backtrack))
        (catch
         Exception
         e__14592__auto__
         (if
          (clojure.core/identical?
           e__14592__auto__

           clojure.core.match/backtrack)
          (do (throw clojure.core.match/backtrack))
          (throw e__14592__auto__))))
       :else
       (throw clojure.core.match/backtrack))
      (catch
       Exception
       e__14592__auto__
       (if
        (clojure.core/identical?
         e__14592__auto__
         clojure.core.match/backtrack)
        (do
         (try
          (clojure.core/cond
           (clojure.core/= z false)
           3
           :else
           (throw clojure.core.match/backtrack))
          (catch
           Exception
           e__14592__auto__
           (if
            (clojure.core/identical?
             e__14592__auto__
             clojure.core.match/backtrack)
            (do
             (try
              (clojure.core/cond
               (clojure.core/= z true)
               4
               :else
               (throw clojure.core.match/backtrack))
              (catch
               Exception
               e__14592__auto__
               (if
                (clojure.core/identical?
                 e__14592__auto__
                 clojure.core.match/backtrack)
                (do
                 (throw
                  (java.lang.IllegalArgumentException.
                   (clojure.core/str
                    "No matching clause: "
                    x
                    " "
                    ocr-15544
                    " "
                    z))))
                (throw e__14592__auto__)))))
            (throw e__14592__auto__)))))
        (throw e__14592__auto__)))))
    (throw e__14592__auto__)))))







(import [java.lang.annotation Retention RetentionPolicy Target ElementType]
        [javax.xml.ws WebServiceRef WebServiceRefs])

(definterface Foo (foo []))

;; annotation on type


[:a1 2 [1 2]]


(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
