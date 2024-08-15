package com.techyourchance.dagger2course.common.dependencyinjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import java.lang.reflect.Field

class Injector(private val component: PresentationComponent) {
    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

    private fun isAnnotatedInjection(field: Field): Boolean {
        for (annotation in field.annotations) {
            if (annotation is Service) {
                return true
            }
        }
        return false
    }

    private fun injectField(client: Any, field: Field) {
        val initialAccessible = field.isAccessible
        field.isAccessible = true
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = initialAccessible
    }

    private fun getServiceForClass(type: Class<*>): Any {
        return when (type) {
            ScreensNavigator::class.java -> component.screensNavigator()
            DialogsNavigator::class.java -> component.dialogsNavigator()
            FetchQuestionsUseCase::class.java -> component.fetchQuestionsUseCase()
            FetchQuestionDetailUseCase::class.java -> component.fetchQuestionDetails()
            ViewMvcFactory::class.java -> component.viewMvcFactory()
            else -> throw IllegalArgumentException("Unsupported service type: $type")
        }
    }
}