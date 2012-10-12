# Little repo for a piggieback bug report. 

Piggieback doesn't seems to work when you start the nREPL server manually, as stated in the
documentation.

To check see do this:

    lein run
    # from another console:
    lein repl :connect 5050
    (piggie-doesnt-work.core/start-browser-listener-from-Nrepl)

Now a long "java.lang.RuntimeException: No Context associated with current Thread" traceback
will be displayed. 

Starting the nREPL using "lein repl" seems to work ok.

Lein version: Leiningen 2.0.0-preview10 on Java 1.7.0_05 Java HotSpot(TM) 64-Bit Server VM

