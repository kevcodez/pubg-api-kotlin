package de.kevcodez.pubg.exception

import okhttp3.Response

class ApiException(private val response: Response) : RuntimeException() {

    override fun toString(): String {
        return "API Exception\nResponse status code: ${response.code()}\nResponse body: ${response.body()?.string()}"
    }
}