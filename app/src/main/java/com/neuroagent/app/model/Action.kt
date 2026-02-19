package com.neuroagent.app.model

/**
 * Classe que representa uma ação individual a ser executada pelo NeuroAgent
 */
data class Action(
    val action: String,      // Tipo de ação: go_to, click, type, open_app
    val value: String? = null,      // Valor para go_to e open_app
    val selector: String? = null,   // Seletor CSS para click e type
    val text: String? = null        // Texto para type (compatibilidade com value)
) {
    /**
     * Valida se a ação tem os parâmetros necessários
     */
    fun isValid(): Boolean {
        return when (action) {
            "go_to" -> !value.isNullOrEmpty()
            "click" -> !selector.isNullOrEmpty()
            "type" -> !selector.isNullOrEmpty() && (!value.isNullOrEmpty() || !text.isNullOrEmpty())
            "open_app" -> !value.isNullOrEmpty()
            else -> false
        }
    }
}

/**
 * Classe que representa a resposta da IA com as ações estruturadas
 */
data class AIResponse(
    val actions: List<Action> = emptyList()
)