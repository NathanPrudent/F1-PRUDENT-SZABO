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
data class PlantResponse(val plantes : List<Plant>)

@Serializable
data class Plant(val nom: String, val description: String, val type: String, val croissance: String, val consommation: String, val image: String)

suspend fun plantsRequest() : List<Plant>
{
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }


    val plantResponse: PlantResponse = client.get("https://jsonkeeper.com/b/ZS2L")

    return plantResponse.plantes
}

