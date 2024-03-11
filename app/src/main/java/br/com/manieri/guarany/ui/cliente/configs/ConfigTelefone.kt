package br.com.manieri.guarany.ui.cliente.configs

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun configTelefone(editText: EditText){
    editText.addTextChangedListener(object : TextWatcher {
        var isUpdating: Boolean = false
        val mask = "(##) #####-####"

        override fun afterTextChanged(s: Editable?) {
            if (isUpdating) {
                isUpdating = false
                return
            }

            var str = s.toString().filterNot { it in "-() " }
            if (str.length > 11)
                str = str.substring(0, 11)

            var maskCurrent = ""
            var i = 0
            for (m in mask.toCharArray()) {
                if (m != '#' && str.length > i) {
                    maskCurrent += m
                    continue
                }
                try {
                    maskCurrent += str[i]
                } catch (e: Exception) {
                    break
                }
                i++
            }

            isUpdating = true
            s?.replace(0, s.length, maskCurrent)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}