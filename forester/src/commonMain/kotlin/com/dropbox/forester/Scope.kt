package com.dropbox.forester


interface Group

interface Scope {
    val groups: List<Group>
}

interface TestScope : Scope


@Node([TestScope::class])
interface Test {

}