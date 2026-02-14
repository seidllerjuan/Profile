package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


object ImageManager{
    private val imagesArray = listOf(
        R.drawable.avatar,
        R.drawable.los_reyes_del_imp
    )

    private var index = 0

    fun getCurrentImage(): Int {
        return imagesArray[index]
    }

    fun nextImage(): Int{
        index = (index + 1) % imagesArray.size
        return getCurrentImage()
    }

}

@Composable
fun FollowButton(modifier: Modifier = Modifier) {

    var following by remember { mutableStateOf(false) }

    val buttonText = if (following) "Siguiendo" else "Seguir"
    val buttonIcon =
        if (following) Icons.Default.Notifications
        else Icons.Default.AddCircle

    Button(
        onClick = { following = !following },
        modifier = modifier
            .height(40.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3a3b3c)
        ),
        contentPadding = PaddingValues(
            horizontal = 6.dp,
            vertical = 2.dp
        )

    ) {
        Icon(
            imageVector = buttonIcon,
            contentDescription = buttonText,
            tint = Color.White
        )
        Spacer(Modifier.width(4.dp))
        Text(buttonText, color = Color.White)
    }
}



@Composable
fun ImageContext(){

    var currentImage by remember {
        mutableStateOf(ImageManager.getCurrentImage())
    }

    Image(
        painter = painterResource(id = currentImage),
        contentDescription = "Foto perfil",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(140.dp)
            .clip(CircleShape)
            .border(4.dp, Color(0xFF1c1e21), CircleShape)
            .clickable(){
                currentImage = ImageManager.nextImage()
            }
    )

}

@Preview(showBackground = true)
@Composable
fun PerfilMultiservicios() {

    // Primero debemos de crear una variable que contenga el primer texto que despues del click sera cambiado en la linea 109 se pueden encontar los cambios
    var textoDescripcion by rememberSaveable {
        mutableStateOf(
            "En Multiservicios Castan ofrecemos todo tipo de servicios para el mantenimiento y reparación del hogar en Tampico, Tamaulipas."
        )
    }

    var titulo by rememberSaveable {
        mutableStateOf("Multiservicios Castan: Soluciones para tu hogar en Tampico")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1c1e21))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Header + avatar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Blue)
                    .align(Alignment.TopCenter)
            ){
                Image(
                    painter = painterResource(R.drawable.los_reyes_del_imp),
                    contentDescription = "Los reyes de la impermeabilizacion",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.BottomCenter

                )
            }

            ImageContext()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = titulo,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "128 seguidores • 1 seguidos",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            //verticalAlignment = Alignment.CenterVertically
        ) {

            FollowButton(
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    textoDescripcion =
                        "Estamos trabajando en nuestra nueva plataforma digital para brindarte una experiencia mejorada."
                },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0866ff)
                ),
                contentPadding =  PaddingValues(
                    horizontal = 6.dp,
                    vertical = 2.dp
                )
            ) {
                Icon(Icons.Default.Email, contentDescription = "Mensaje")
                Spacer(Modifier.width(4.dp))
                Text("Mensaje", color = Color.White)
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3a3b3c)
                ),
                contentPadding =  PaddingValues(
                    horizontal = 6.dp,
                    vertical = 2.dp
                )
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
                Spacer(Modifier.width(4.dp))
                Text("Buscar", color = Color.White)
            }
        }


        Text(
            text = textoDescripcion,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Editar título") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}