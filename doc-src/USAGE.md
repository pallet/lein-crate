## Usage

To add leiningen to a `server-spec` or a `group-spec`:

```clj
(require '[pallet.crate.lein :as lein])
(server-spec :extends (lein/leiningen {}))
```

Options are:

`:dir`
directory to install the lein script.  Defaults to `/usr/local/bin`

`:exec-name`
name to use for the script.  Defaults to `lein`.

`:version`
version of leiningen to install.  Should be a tag in the leiningen
repository. Defaults to `stable`.


The crate provides a `lein` function, to execute lein with arguments.
