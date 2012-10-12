(ns piggie-doesnt-work.core
  (:require [cljs.repl         :as cljsrepl]
            [cljs.repl.browser :as browser]

            [clojure.tools.nrepl.server :as nrepl]
            [cemerick.piggieback        :as piggie]
            complete.core   ;; for nrepl completion
            ))

(defn start-nrepl-server []
  (nrepl/start-server
   :handler (nrepl/default-handler #'piggie/wrap-cljs-repl)
   :port 5050
  ; ...additional `start-server` options as desired
  )
)

;; CLJS connects to this
(defn -get-cljs-browser-listener [] 
  (browser/repl-env :port 9000
                    :working-dir "/tmp/repl"
                    :serve-static true
                    :static-dir ["web/"]
                    :src "src-cljs/"
                    )
  )

;; Run from NREPL
;; Works when running "lein repl"
;; NOT when connecting from Emacs (java.lang.RuntimeException: No Context associated with current Thread)
(defn start-browser-listener-from-Nrepl []
  (let [env (-get-cljs-browser-listener)]
    (cljsrepl/-setup env)
    (piggie/cljs-repl :repl-env env)
  )
)

(defn -main [& args] 
  (println "Starting...")
  (start-nrepl-server) 
  (println "Awaiting NREPL connection to 5050, connect and run (piggie-doesnt-work.core/start-browser-listener-from-Nrepl) to see the bug")
  )
