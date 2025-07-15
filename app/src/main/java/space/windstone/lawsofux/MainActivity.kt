package space.windstone.lawsofux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import space.windstone.lawsofux.ui.composables.RootLayout
import space.windstone.lawsofux.ui.theme.LawsOfUXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LawsOfUXTheme {
                RootLayout {
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                    Text(text = "Asdfsdfndroid")
                }
            }
        }
    }
}