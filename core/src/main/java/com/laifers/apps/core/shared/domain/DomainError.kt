package com.laifers.apps.core.shared.domain

abstract class DomainError(message: String?) : Exception(message)

class InvalidValue(message: String) : DomainError(message)