(ns clojure-congomongo-test.core
  (:require [somnium.congomongo :as m]))


(def conn
  (m/make-connection "mydb"
                     :host "127.0.0.1"
                     :port 27017))


(defn initialize []
  (m/with-mongo conn
    (doseq [entry [{:_id "dean.darity@mail.com" :full-name "Dean Darity" :roles [:admin :admin-of-a] :age 32}
                   {:_id "america.mallen@mail.com" :full-name "America Mallen" :roles [:admin :admin-of-b] :age 21}
                   {:_id "preston.stigall@mail.com" :full-name "Preston Stigall" :roles [:admin-of-a :admin-of-b]}
                   {:_id "hanna.conlon@mail.com" :full-name "Hanna Conlon" :roles [:user-of-a]}
                   {:_id "conrad.haffner@mail.com" :full-name "Conrad Haffner" :age 50}]]
      (m/update! :profiles (select-keys entry [:_id]) entry :upsert true))))


;; https://github.com/aboekhoff/congomongo/tree/0.4.4
;; http://docs.mongodb.org/manual/reference/operator/


(defn get-profile-by-full-name [full-name]
  (m/with-mongo conn

    ))

(comment
  (get-profile-by-full-name "Dean Darity")
  )

;;;;;;

(defn get-profiles-older-than [age]
  (m/with-mongo conn
    ;; :$operator
    ))

(comment
  (get-profiles-older-than 30)
  )

;;;;;;

(defn get-profiles-by-roles [roles]
  (m/with-mongo conn

    ))

(comment
  (get-profiles-by-roles [:user-of-a :admin])
  )

;;;;;;

(defn update-profile-full-name! [id full-name]
  (m/with-mongo conn

    ))

(comment
  (update-profile-full-name! "hanna.conlon@mail.com" "Hanna Thornton")
  )

;;;;;;

(defn increase-profile-age! [id]
  (m/with-mongo conn

    ))

(comment
  (increase-profile-age! "dean.darity@mail.com")
  )

;;;;;;

(defn add-profile-to-role! [id role]
  (m/with-mongo conn

    ))

(comment
  (add-profile-to-role! "conrad.haffner@mail.com" :user-of-c)
  )
