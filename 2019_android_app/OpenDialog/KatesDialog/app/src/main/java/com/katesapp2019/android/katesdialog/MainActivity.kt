package com.katesapp2019.android.katesdialog

import android.os.Bundle
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
//import com.afollestad.assent.Permission.READ_EXTERNAL_STORAGE
//import com.afollestad.assent.Permission.WRITE_EXTERNAL_STORAGE
//import com.afollestad.assent.runWithPermissions
import com.afollestad.materialdialogs.DialogBehavior
import com.afollestad.materialdialogs.LayoutMode.WRAP_CONTENT
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.ModalDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.callbacks.onShow
import com.afollestad.materialdialogs.checkbox.checkBoxPrompt
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
//import com.afollestad.materialdialogs.files.fileChooser
//import com.afollestad.materialdialogs.files.folderChooser
//import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.list.listItems
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.katesapp2019.android.katesdialog.R.id.basic
import kotlinx.android.synthetic.main.activity_main.basic
import kotlinx.android.synthetic.main.activity_main.basic_content
import kotlinx.android.synthetic.main.activity_main.buttons_callbacks
import kotlinx.android.synthetic.main.activity_main.buttons_stacked
//import kotlinx.android.synthetic.main.activity_main.custom_view_webview
import kotlinx.android.synthetic.main.activity_main.date_picker
import kotlinx.android.synthetic.main.activity_main.file_chooser_buttons
import kotlinx.android.synthetic.main.activity_main.file_chooser_filter
import kotlinx.android.synthetic.main.activity_main.folder_chooser_buttons
import kotlinx.android.synthetic.main.activity_main.folder_chooser_filter
import kotlinx.android.synthetic.main.activity_main.input
import kotlinx.android.synthetic.main.activity_main.input_message
import kotlinx.android.synthetic.main.activity_main.list
import kotlinx.android.synthetic.main.activity_main.checkbox
import kotlinx.android.synthetic.main.activity_main.misc_dialog_callbacks
import kotlinx.android.synthetic.main.activity_main.single_choice_disabled_items
import kotlinx.android.synthetic.main.activity_main.single_choice_titled


class MainActivity : AppCompatActivity() {

    var basic: Button? = null
    var content: Button? = null
    var checkbox: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        basic = findViewById(R.id.basic)
        basic!!.setOnClickListener {
            MaterialDialog(this).show {
                message(R.string.shareLocationPrompt)
            }
        }

        content = findViewById(R.id.basic_content)
        content!!.setOnClickListener {
            MaterialDialog(this).show {
                title(R.string.app_name)
                message(R.string.htmlContent) {
                    html { toast("click link to : $it") }
                    lineSpacing((1.5f))
                }
            }
        }

        checkbox = findViewById(R.id.checkbox)
        checkbox!!.setOnClickListener {
            MaterialDialog(this).show {
                customView(R.layout.dialog_checkbox)
            }
        }

    }

}