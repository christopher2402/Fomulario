package ejemplo.proyecto.formulario.christopher.fomulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Nombre, Apellido, Correo, Edad, Hobbies;
    RadioGroup Radio;
    Button Ejecutar;

    String sexo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.inputNombre);
        Apellido = (EditText) findViewById(R.id.inputApellido1);
        Correo = (EditText) findViewById(R.id.inpCorreo);
        Edad = (EditText) findViewById(R.id.inpFecha);
        Hobbies = (EditText) findViewById(R.id.inpHobbies);

        Radio = (RadioGroup) findViewById(R.id.radio);
        Radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              sexo =  seleccionarSexo(checkedId);
            }
        });

        Ejecutar = (Button) findViewById(R.id.ejecutar);
        Ejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Nombre: "+Nombre.getText()+
                        "\nApellido: "+Apellido.getText()+
                        "\nCorreo: "+Correo.getText()+
                        "\nEdad: "+Edad.getText()+
                        "\nHobbies: "+Hobbies.getText()+
                        "\nSexo: "+sexo,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public String seleccionarSexo(int checkedId)
    {
        String retornar = "";
        if (checkedId == R.id.hombre)
        {
            retornar = "Hombre";
        }else if(checkedId == R.id.mujer)
        {
            retornar = "Mujer";
        }

        return retornar;
    }
}
