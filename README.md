# lein-crate

A [Pallet](http://palletops.com) crate to install and configure
[Leiningen](https://github.com/technomancy/leiningen).

[Release Notes](ReleaseNotes.md) &#xb7; 
[API docs](http://palletops.com/java-crate/api/0.8/) &#xb7;
[Annotated code](http://palletops.com/java-crate/annotated/0.8/uberdoc.html).

```
[com.palletops/lein-crate "0.8.0-alpha.1"]
```

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

## Tests

To run the live tests on VirtualBox:

```
lein live-test-up
```

To run tests against all supported targets:

```
lein live-test-up --selectors all
```

To remove test nodes:

```
lein live-test-down --selectors all
```

## License

Copyright © 2013 Hugo Duncan

Distributed under the Eclipse Public License.
