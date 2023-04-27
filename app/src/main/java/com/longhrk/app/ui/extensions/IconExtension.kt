package com.longhrk.app.ui.extensions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

class IconExtension {
    companion object {
        val Diamond: ImageVector
            get() {
                if (_diamond != null) {
                    return _diamond!!
                }
                _diamond = materialIcon(name = "Filled.Diamond") {
                    materialPath {
                        moveTo(12.16f, 3.0f)
                        lineToRelative(-0.32f, 0.0f)
                        lineToRelative(-2.63f, 5.25f)
                        lineToRelative(5.58f, 0.0f)
                        close()
                    }
                    materialPath {
                        moveTo(16.46f, 8.25f)
                        lineToRelative(5.16f, 0.0f)
                        lineToRelative(-2.62f, -5.25f)
                        lineToRelative(-5.16f, 0.0f)
                        close()
                    }
                    materialPath {
                        moveTo(21.38f, 9.75f)
                        lineToRelative(-8.63f, 0.0f)
                        lineToRelative(0.0f, 10.35f)
                        close()
                    }
                    materialPath {
                        moveTo(11.25f, 20.1f)
                        lineToRelative(0.0f, -10.35f)
                        lineToRelative(-8.63f, 0.0f)
                        close()
                    }
                    materialPath {
                        moveTo(7.54f, 8.25f)
                        lineToRelative(2.62f, -5.25f)
                        lineToRelative(-5.16f, 0.0f)
                        lineToRelative(-2.62f, 5.25f)
                        close()
                    }
                }
                return _diamond!!
            }

        private var _diamond: ImageVector? = null
    }
}