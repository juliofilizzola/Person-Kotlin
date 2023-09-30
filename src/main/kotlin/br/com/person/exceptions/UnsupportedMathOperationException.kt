package br.com.person.exceptions

import java.lang.RuntimeException

class UnsupportedOperationException(exception: String?): RuntimeException(exception)