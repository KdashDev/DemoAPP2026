# DemoAPP - GitHub Portfolio Avanzado 🚀

[![Repo](https://img.shields.io/badge/Repository-GitHub-181717?logo=github)](https://github.com/KdashDev/DemoAPP2026)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue?logo=kotlin)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Jetpack-Compose-4285F4?logo=android)](https://developer.android.com/jetpack/compose)

Esta es una aplicación de portafolio Android de alto nivel desarrollada bajo estándares de **Ingeniería de Software Senior**. La app consume la API pública de GitHub para mostrar proyectos reales, aplicando patrones de diseño modernos y una arquitectura escalable.

🔗 **Repositorio Oficial:** [https://github.com/KdashDev/DemoAPP2026](https://github.com/KdashDev/DemoAPP2026)

---

## 🎯 ¿Por qué este proyecto destaca para un Reclutador?

Este repositorio no es solo una "lista de tareas". Demuestra dominio en áreas críticas para el desarrollo de aplicaciones empresariales:

1.  **Arquitectura MVI Real:** Implementación de un flujo unidireccional de datos (UDF) con estados inmutables, facilitando el testing y la depuración.
2.  **Estrategia de Datos Senior:** No solo consume una API; maneja una estrategia de **Caché (Stale-While-Revalidate)** para asegurar que el usuario siempre vea contenido, incluso sin conexión.
3.  **UI/UX Refinada:** Uso de animaciones escalonadas y manejo exhaustivo de estados (Loading, Empty, Error, Content) para una experiencia de usuario fluida.
4.  **Modern Build System:** Uso de **Version Catalogs (libs.versions.toml)** y Gradle Kotlin DSL, estándares actuales en la industria.
5.  **Inyección de Dependencias Robusta:** Configuración profesional de **Hilt** para desacoplar componentes y mejorar la mantenibilidad.

---

## 1. Tecnologías y Herramientas 🛠️

- **Lenguaje:** [Kotlin Moderno](https://kotlinlang.org/) utilizando **Coroutines** para asincronía y **Flow/Channels** para flujos de datos reactivos.
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) para una interfaz declarativa.
- **Navegación:** Navigation Component con soporte para adaptabilidad (Navigation Suite).
- **Red y Datos:** 
    - [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/) para consumo de API.
    - [Kotlinx Serialization](https://kotlinlang.org/docs/serialization.html) para el parseo de JSON.
    - Estrategia de **Caché Local**: Lógica de persistencia/caché en la capa de repositorio.
- **DI:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) para la inyección de dependencias.
- **Carga de Imágenes:** [Coil](https://coil-kt.github.io/coil/) para una gestión eficiente de imágenes remotas.

## 2. Arquitectura: MVI (Model-View-Intent) 🏗️

La aplicación implementa una arquitectura **MVI** con estados de UI inmutables:

- **UIState Unificado:** `PortfolioUiState` maneja de forma atómica la carga, los datos (`List<Repository>`) y los errores.
- **Intents:** Acciones claras del usuario (Load, Refresh, Click) representadas en `PortfolioIntent`.
- **ViewModel:** Procesa los *Intents* y reduce el estado actual hacia la vista mediante un `StateFlow`.
- **Data Layer:** Desacoplamiento total entre modelos de red (`Dto`) y modelos de dominio.

## 3. Características Principales ✨

- **Animaciones Senior:** Implementación de `AnimatedVisibility` con efectos de deslizamiento y desvanecimiento escalonados.
- **Manejo de Estados Robusto:** Feedback visual durante la carga, gestión de listas vacías y pantalla de error con lógica de **"Reintentar" (Retry)**.
- **Clean Code:** Organización por módulos lógicos y nomenclatura semántica siguiendo las guías oficiales de Google.

## 4. Estructura del Proyecto 📁

```text
app/src/main/java/com/example/demoapp/
├── data/
│   ├── model/      # Modelos de datos y Mappers (Dto to Domain)
│   ├── remote/     # Definición de API (Retrofit)
│   └── repository/ # Lógica de negocio y estrategia de caché
├── di/             # Módulos de Hilt (Dependency Injection)
├── ui/
│   ├── portfolio/  # Pantallas, ViewModels y Contratos MVI
│   └── theme/      # Configuración de Material 3
└── DemoApplication.kt # Punto de entrada (Hilt App)
```

---
Desarrollado con ❤️ para demostrar estándares de calidad en el ecosistema Android moderno.
