[Repository](https://github.com/pallet/lein-crate) &#xb7; 
[Issues](https://github.com/pallet/lein-crate/issues) &#xb7; 
[API docs](http://palletops.com/lein-crate/0.8/api) &#xb7; 
[Annotated source](http://palletops.com/lein-crate/0.8/annotated/uberdoc.html) &#xb7; 
[Release Notes](https://github.com/pallet/lein-crate/blob/develop/ReleaseNotes.md)

A [pallet](http://palletops.com/) crate to install and configure
[leiningen](https://github.com/technomancy/leiningen).

### Dependency Information

```clj
:dependencies [[com.palletops/lein "0.8.0-alpha.1"]]
```

### Releases

<table>
<thead>
  <tr><th>Pallet</th><th>Crate Version</th><th>Repo</th><th>GroupId</th></tr>
</thead>
<tbody>
  <tr>
    <th>0.8.0-beta.1</th>
    <td>0.8.0-alpha.1</td>
    <td>clojars</td>
    <td>com.palletops</td>
    <td><a href='https://github.com/pallet/lein-crate/blob/0.8.0-alpha.1/ReleaseNotes.md'>Release Notes</a></td>
    <td><a href='https://github.com/pallet/lein-crate/blob/0.8.0-alpha.1/'>Source</a></td>
  </tr>
</tbody>
</table>

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
