package site.tsun.mybatisdemo.model

data class HttpResult(val success: Boolean = true, val errors: ArrayList<String> = arrayListOf())