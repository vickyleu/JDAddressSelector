package chihane.jdaddressselector

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.Gravity
import android.view.WindowManager
import mlxy.utils.Dev

class BottomDialog : Dialog {
    private var selector: AddressSelector? = null

    constructor(context: Context) : super(context, R.style.bottom_dialog) {
        init(context)
    }

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {
        init(context)
    }

    constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener?
    ) : super(context, cancelable, cancelListener) {
        init(context)
    }

    private fun init(context: Context) {
        selector = AddressSelector(context)
        setContentView(selector!!.view)
        val window = window
        val params = window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = Dev.dp2px(context, 256f)
        window.attributes = params
        window.setGravity(Gravity.BOTTOM)
    }

    fun setOnAddressSelectedListener(listener: OnAddressSelectedListener?) {
        selector?.onAddressSelectedListener = listener
    }

    companion object {
        @JvmOverloads
        fun show(context: Context, listener: OnAddressSelectedListener? = null): BottomDialog {
            val dialog = BottomDialog(context, R.style.bottom_dialog)
            dialog.selector?.onAddressSelectedListener = (listener)
            dialog.show()
            return dialog
        }
    }
}