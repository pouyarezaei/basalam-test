package com.github.pouyarezaei.basalam_t1.data.remote

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String
        get() = "No Internet Connection"

}