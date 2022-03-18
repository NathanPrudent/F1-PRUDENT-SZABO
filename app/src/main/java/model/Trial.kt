package model

import android.widget.TextView
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
data class TrialResponse(val epreuves : List<Trial>)

@Serializable
data class Trial(val nom: String, val description: String, val type: String, val jour: String, val image: String)

suspend fun trialsRequest() : List<Trial>
{
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }


    val trialResponse: TrialResponse = client.get("https://jsonkeeper.com/b/9ZBP")

    return trialResponse.epreuves
}

