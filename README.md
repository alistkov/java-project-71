# Difference Calculator (Java)

[![hexlet-check](https://github.com/alistkov/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/alistkov/java-project-71/actions)
[![Build](https://github.com/alistkov/java-project-71/actions/workflows/build.yml/badge.svg)](https://github.com/alistkov/java-project-71/actions/workflows/build.yml)

## Features

- Supported input formats: **JSON** and **YAML** (`.yml`, `.yaml`)
- Three output formats for the differences: **stylish** (default), **plain**, **json**
- Support for nested structures
- Relative and absolute file paths

## Tech Stack

| Technology           | Purpose                                       |
| -------------------- | --------------------------------------------- |
| Java                 | Programming language                          |
| Gradle               | Build tool and dependency management          |
| Jackson (JSON, YAML) | Parsing input files and producing JSON output |
| Picocli              | Command-line argument parsing                 |
| JUnit                | Testing                                       |
| JaCoCo               | Test coverage verification                    |
| Spotless             | Code style checking and auto-formatting       |
| GitHub Actions       | Continuous integration (CI)                   |
| Make                 | Short commands for common tasks               |

## Installation

```bash
git clone https://github.com/alistkov/java-project-71.git
cd java-project-71
make install-dist
```

After the build, the executable is located at build/install/app/bin/app.

## Usage

```bash
./build/install/app/bin/app [-hV] [-f=<format>] <filepath1> <filepath2>
```

| Option            | Description                                   |
| ----------------- | --------------------------------------------- |
| `-f`, `--format`  | Output format: stylish (default), plain, json |
| `-h`, `--help`    | Show help                                     |
| `-V`, `--version` | Show version                                  |

### Examples

```bash
./build/install/app/bin/app file1.json file2.json
./build/install/app/bin/app -f plain file1.yml file2.yml
./build/install/app/bin/app -f json file1.json file2.yml
```

### Output Formats

**stylish** — a tree of changes marked with `+` and `-`:

```
{
  - follow: false
    host: hexlet.io
  - proxy: 123.234.53.22
  - timeout: 50
  + timeout: 20
  + verbose: true
}
```

**plain** — a flat, human-readable list of changes:

```
Property 'follow' was removed
Property 'proxy' was removed
Property 'timeout' was updated. From 50 to 20
Property 'verbose' was added with value: true
```

**json** — the comparison result as JSON, ready for further processing by other programs.

## Commands

### Build

| Command              | Description                                              |
| -------------------- | -------------------------------------------------------- |
| `make install-dist ` | Clean and build the application into `build/install/app` |
| `make build`         | Full project build (`clean build`)                       |
| `make clean`         | Remove build artifacts                                   |

### Testing and Code Quality

| Command              | Description                         |
| -------------------- | ----------------------------------- |
| `make test`          | Run tests                           |
| `make test-coverage` | Verify test coverage (JaCoCo)       |
| `make lint`          | Check code style (Spotless)         |
| `make lint-fix`      | Automatically fix code style issues |

### Dependencies

| Command              | Description                           |
| -------------------- | ------------------------------------- |
| `make check-updates` | Look for available dependency updates |

## Demo (asciinema)

### Comparing Flat Files

| Format  | Files | Recording                                                       |
| ------- | ----- | --------------------------------------------------------------- |
| stylish | JSON  | <a href="https://asciinema.org/a/<>" target="_blank">Watch</a>  |
| plain   | JSON  | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |
| json    | JSON  | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |

### Comparing Nested Structures

| Format  | Files | Recording                                                       |
| ------- | ----- | --------------------------------------------------------------- |
| stylish | JSON  | <a href="https://asciinema.org/a/<>" target="_blank">Watch</a>  |
| stylish | YML   | <a href="https://asciinema.org/a/<>" target="_blank">Watch</a>  |
| plain   | JSON  | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |
| plain   | YML   | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |
| json    | JSON  | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |
| json    | YML   | <a href="https://asciinema.org/a/<>>" target="_blank">Watch</a> |
