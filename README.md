# Forester

<img src=".github/mapping_out_the_forest.png" alt="Mapping out the forest" height="450"/>

## Problem

It's crucial to have a comprehensive understanding of a system's architecture. Architecture diagrams offer valuable
visual representations of the system's structure and its components. However, as a codebase evolves and its architecture
adapts, maintaining synchronization between the code and diagrams can become increasingly challenging. Outdated diagrams
can result in miscommunication, misconceptions about the system, and ultimately, increased development and maintenance
costs.

## Solution

Forester keeps code and diagrams aligned:

- **Automatic generation.** Forester parses your code and generates architecture diagrams based on your code's
  structure and annotations.
- **Version control.** Store your architecture diagrams alongside your code in the same version control system.
- **Continuous integration.** Integrate Forester into your CI pipeline to generate and update diagrams automatically
  whenever significant code changes are made.
- **Collaboration.** Promote a culture of shared responsibility for keeping architecture diagrams current among your
  engineering team.

## Concepts

- [Node](/README.md)
- [Forest](/README.md)
- [Graph](/README.md)
- [Directed](/README.md)
- [Undirected](/README.md)

## Usage

```kotlin
@Node
@Undirected([Repository::class])
interface Api {
    suspend fun getCount(): Int
    suspend fun setCount(count: Int)
}
```

```kotlin
@Node
@Directed([ViewModel::class])
interface Repository {
    suspend fun getCount(): Result<Int>
    suspend fun setCount(count: Int): Result<Int>
}
```

```kotlin
@Node
interface ViewModel {
    val state: StateFlow<State>
    fun load()
    fun on(event: Event)
}
```

```kotlin
@Forest
object Server {
    object Counter {
        val subscribe = node("server.counter.subscribe", Shape.Cloud)
    }
}
```

```kotlin
@Forest
object Xplat {
    object Counter {
        val CounterScreen = node("xplat.counter.CounterScreen", Shape.Parallelogram)
    }
}
```

```kotlin
@Graph
class CounterGraph {
    fun provide() = graph {
        directed(Server.Counter.subscribe, Api::class)
        directed(ViewModel::class, Xplat.Counter.CounterScreen)
    }
}
```

<img src=".github/sample_class.png" height="650"/>

## License

```txt
Copyright 2023 Dropbox

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
