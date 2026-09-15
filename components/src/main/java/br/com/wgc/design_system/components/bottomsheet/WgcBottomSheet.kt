package br.com.wgc.design_system.components.bottomsheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Gaveta inferior modal do Design System (WgcBottomSheet) baseada no Material 3.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        modifier = modifier,
        content = content
    )
}
