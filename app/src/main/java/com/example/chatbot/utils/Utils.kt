package de.syntax.androidabschluss.utils

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import de.syntax.androidabschluss.R

val assistantImageList = listOf(
    R.drawable.robot_1,
    R.drawable.robot_2,
    R.drawable.robot_3,
    R.drawable.testlogo,




)
enum class Status{
    LOADING,
    SUCCESS,
    ERROR

}
enum class NetworkStatus{
    Available,Unavailable
}

enum class  StatusResult {
    Added,
    Updated,
    Deleted
}


fun appSettingOpen(context: Context){
    Toast.makeText(
        context,
        "Go to Setting and Enable All Permission",
        Toast.LENGTH_LONG
    ).show()

    val settingIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    settingIntent.data = Uri.parse("package:${context.packageName}")
    context.startActivity(settingIntent)
}

fun warningPermissionDialog(context: Context,listener : DialogInterface.OnClickListener){
    MaterialAlertDialogBuilder(context)
        .setMessage("All Permission are Required for this app")
        .setCancelable(false)
        .setPositiveButton("Ok",listener)
        .create()
        .show()
}

fun Context.hideKeyBoard(it: View) {
    try {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken,0)
    }catch (e:Exception){
        e.printStackTrace()
    }
}


fun Context.longToastShow(message: String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()

}
//------
fun Context.copyToClipBoard(message: String) {
    val clipBoard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text",message)
    clipBoard.setPrimaryClip(clip)
    longToastShow("Copied")
}

 fun Context.shareMsg(message: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT,message)
    startActivity(Intent.createChooser(intent,"Share Message"))
}

fun Dialog.setupDialog(layoutResId : Int){
    setContentView(layoutResId)
    window!!.setLayout(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
    setCancelable(false)
}

// For the translator--Target languages from documentation
val languageFullNames = listOf(
    "Arabic",
    "Bulgarian",
    "Czech",
    "Danish",
    "German",
    "Greek",
    "English",
    "English (British)",
    "English (American)",
    "Spanish",
    "Estonian",
    "Finnish",
    "French",
    "Hungarian",
    "Indonesian",
    "Italian",
    "Japanese",
    "Korean",
    "Lithuanian",
    "Latvian",
    "Norwegian (Bokmål)",
    "Dutch",
    "Polish",
    "Portuguese (unspecified variant for backward compatibility; please select PT-BR or PT-PT instead)",
    "Portuguese (Brazilian)",
    "Portuguese (all Portuguese varieties excluding Brazilian Portuguese)",
    "Romanian",
    "Russian",
    "Slovak",
    "Slovenian",
    "Swedish",
    "Turkish",
    "Ukrainian",
    "Chinese (simplified)"
)

//----------Strokecolors
        fun getAuoraColor(context: Context) = ContextCompat.getColor(context, R.color.blau)
        fun getSnowColor(context: Context) = ContextCompat.getColor(context, R.color.weiß)
        fun getMatrixColor(context: Context) = ContextCompat.getColor(context, R.color.grün)
        fun getRoseColor(context: Context) = ContextCompat.getColor(context, R.color.rose)
        fun getEvilColor(context: Context) = ContextCompat.getColor(context, R.color.rot)


//----------Animations
fun startButtonAnimation(context: Context, view: View, animationResource: Int = R.anim.anima) {
    val vibrationAnimation = AnimationUtils.loadAnimation(context, animationResource)
    view.startAnimation(vibrationAnimation)
}


//prompts

//                android:text="A Miki mouse with Typography, text 'Pascal' With a background of a night cyberpunk city with many colored lights all beatiful in 3D, photo, poster, 3d render, cinematic, anime, vibrant, typography, painting, conceptual art 'Pascal'"
//Albert Einstein eating an ice cream in the style of Laika Studios, Tim Burton, cinematic, A hauntingly beautiful illustration of Albert Einstein, depicted in the unique style of Laika Studios and Tim Burton. The renowned physicist is seen sitting on a mysterious, moonlit park bench, with a brooding sky overhead. He is enjoying a single scoop of ice cream in a cone, which is glowing ominously. The overall atmosphere of the scene is both whimsical and dark, capturing the essence of Tim Burton's cinematic universe., cinematic
