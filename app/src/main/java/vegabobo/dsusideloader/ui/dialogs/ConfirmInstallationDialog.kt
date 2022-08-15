package vegabobo.dsusideloader.ui.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import vegabobo.dsusideloader.R
import vegabobo.dsusideloader.model.DSUConstants
import vegabobo.dsusideloader.ui.components.Dialog

@Composable
fun ConfirmInstallationDialog(
    dialogText: String = "",
    filename: String,
    userdata: String,
    fileSize: Long,
    onClickConfirm: () -> Unit,
    onClickCancel: () -> Unit,
) {

    val length = if(fileSize == DSUConstants.DEFAULT_IMAGE_SIZE) {
        stringResource(id = R.string.auto)
    }else{
        "${fileSize}b"
    }


    Dialog(
        title = stringResource(id = R.string.info),
        text =
        dialogText.ifEmpty {
            stringResource(
                id = R.string.installation_details,
                filename,
                userdata,
                length
            )
        },
        confirmText = stringResource(id = R.string.proceed),
        cancelText = stringResource(id = R.string.cancel),
        onClickConfirm = { onClickConfirm() },
        onClickCancel = { onClickCancel() })
}