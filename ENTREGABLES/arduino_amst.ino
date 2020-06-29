const int analogInPin = A8;
const int analogBateria = A9;// Analog input pin that the potentiometer is attached to
int sensorValue = 0;
int flag = 0;
int bateria = 0;
int copiaSensor = 0; // value read from the pot

void setup() {
  Serial.begin(9600);
  Serial1.begin(19200);
}

void loop() {
  sensorValue = analogRead(analogInPin);
  while(1){
    copiaSensor = analogRead(analogInPin);
    bateria = analogRead(analogBateria);
    bateria= map(bateria,0,1023,0,100);
    
    Serial1.print(sensorValue);
    Serial1.print(",");
    Serial1.print(copiaSensor);
    Serial1.print(",");
    Serial1.println(bateria);
    if (copiaSensor < (0.95 * sensorValue)){
      break;
    } else if (copiaSensor > (1.05 * sensorValue)){
      break;
    }else if (bateria < 70 ){
      if (flag == 0){
        flag = 1;
        break;
      }
    }
    
    delay(100);
  }
  
    sensorValue = analogRead(analogInPin);
    bateria = analogRead(analogBateria);
    bateria= map(bateria,0,1023,0,100);
    sendMessage(sensorValue,bateria);
    
    
  delay(4000);
}

void sendMessage(int sensor, char bateria){
    Serial.println("AT$RC");
    Serial.print("AT$SF=");
    if(sensorValue<16)Serial.print("000");
    else if(sensorValue<256)Serial.print("00");
    else if(sensorValue<4096)Serial.print("0");
    Serial.print(sensorValue,HEX);
    if (bateria < 16)Serial.print("0");
    Serial.println(bateria,HEX);
  
}
