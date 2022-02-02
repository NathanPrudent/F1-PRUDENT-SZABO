package model

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.*
import kotlinx.serialization.*



@Serializable
data class Contact(val firstName: String, val lastName: String, val numero: String)

fun request(number : Int = 0): Contact = runBlocking{

    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }

    /*
    val response: HttpResponse = client.post("https://api.npoint.io/ddab53cb4dd7e8783be0/contacts") {
        contentType(ContentType.Application.Json)
        body = Contact("Nathan", "Prudent", "06")
    }
    println(response.readText())
    */

    client.get("https://api.npoint.io/ddab53cb4dd7e8783be0/contacts/$number")
}

