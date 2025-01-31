# OpenAI Chatbot mit MVVM und Moshi in Kotlin

In diesem Repository finden Sie alles, was Sie brauchen, um eine OpenAi Chat anfrage zu senden.
## Besonderheiten der App

- **Struktur mit MVVM**: MVVM-Modell für eine robuste und wartbare App-Architektur.
- **Moshi für JSON**: Moshi Factory, was die Kommunikation zwischen App und Backend flüssig und effizient macht.
- **Kotlin im Kern**: Der gesamte Code ist in Kotlin verfasst.

## Technologien im Einsatz
https://platform.openai.com/docs/api-reference/chat
- **Kotlin**
- **Android Studio**
- **MVVM**
- **Moshi**
- **Retrofit**

- (Um einen kompletten Chat zu erzeugen sollte eine Datenbank erstellt werden, in der man die Nachrichten abspeichern kann.)


Wichtig !!
## Build.Gradle-App

In Ihrem `build.gradle` der App-Ebene sollten Sie sicherstellen, dass Sie die folgenden Plugins und Abhängigkeiten inkludieren, um alle Funktionen und Bibliotheken, die in diesem Projekt verwendet werden, korrekt zu integrieren:

```gradle
plugins {
    id("kotlin-kapt")
}

dependencies {
    // Retrofit zur Netzwerkkommunikation
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Moshi zur JSON-Serialisierung
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
}
