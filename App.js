import { StatusBar } from 'expo-status-bar';
import { FlatList, StyleSheet, Text, View,Image, Button, TextInput, TouchableOpacity } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { useEffect, useState } from 'react';
import { initializeApp } from "firebase/app";
import { getDatabase, ref, set, push,onValue,remove } from "firebase/database";
import Modal from 'react-native-modal';

// const firebaseConfig = {
//   apiKey: "AIzaSyAPRZ-DwXEzHpOfE3uGx-AV9Ddy_xCLMbc",
//   authDomain: "noteonline-9de19.firebaseapp.com",
//   projectId: "noteonline-9de19",
//   storageBucket: "noteonline-9de19.appspot.com",
//   messagingSenderId: "156943459608",
//   appId: "1:156943459608:web:0c6277e58e1965d70eea6d",
//   measurementId: "G-1Q773QQXC0",
//   databaseURL : "https://noteonline-9de19-default-rtdb.asia-southeast1.firebasedatabase.app/"
// };

// function Chao({navigation}){
//   const app = initializeApp(firebaseConfig);

//   useEffect( ()=>{
//     const Timer = setTimeout(()=>{
//       navigation.navigate('Chinh');
//     },2000)
//   },[navigation])
//   return(
//     <View>
//         <Text>Man hinh chao</Text>
//     </View>
//   )
// }

// function Chinh ({navigation}){

//   const [data,setData] = useState([]);

//   const [isModalVisible, setModalVisible] = useState(false);
  
//   const toggleModal = () => {
//     setModalVisible(!isModalVisible);
//   };

//   useEffect( ()=>{
//     var requestOptions = {
//       method: 'GET',
//       redirect: 'follow'
//     };
//     fetch("https://dummyjson.com/products", requestOptions)
//       .then(response => response.json())
//       .then(result => setData(result.products))
//       .catch(error => console.log('error', error));
//   },[])

//   return(
//     <View>
//       <FlatList data={data} renderItem={({item,index}) =>{
//         return(
//           <View>
//             <Text>{item.id}</Text>
//             <Text>{item.title}</Text>
//             <Text>{item.description}</Text>
//             <Text>{item.price}</Text>
//             <Image source={{uri : item.images[0]}} style={{width : 50 , height : 50}}/>
//             <Image source={{uri : item.images[1]}} style={{width : 50 , height : 50}}/>
//             <Button title={'dong bo'} onPress={()=>{
//                  const db = getDatabase();
//                  set(ref(db,'products/' + item.id),item).then(
//                    r =>{
//                      if(r != null){
//                        alert('thanh cong');
//                      }
//                    }
//                  )
//             }}/>
//             <Button title={'chi tiet'} onPress={ ()=>{
//                   navigation.navigate('Chitiet',item ={
//                       id : item.id,
//                       title: item.title,
//                       description: item.description,
//                       price: item.price,
//                       images : item.images[0]
//                   });
//             }}/>
//             <Button title={'delete all'} onPress={()=>{

//                 //xoa firebase
//                 const db = getDatabase();
//                 remove(ref(db,'/products/'+ item.id))


//                 //xoa list
//                 var Listfill = data.filter(data => data !== item)
//                 setData(Listfill);
//             }}/>
//             <Button title={'update List'} onPress={()=>{
//                 // var newArray = [...data];
//                 // newArray[index].id = id(TextInput).id
//                 // newArray[index].title = title(TextInput).title
//                 // newArray[index].description = description(TextInput).description
//                 // newArray[index].price = price(TextInput).price
//                 // newArray[index].images = Images(libary).images
//                 // setData(newArray)

//                 //update List nhap thong tin them TextInput va Images lay trong thu vien anh
//                 toggleModal();
//             }}/>
//           </View>
//         )
//       }}/>
//        <Modal isVisible={isModalVisible}>
//           <View style={styles.dialog}>
//             <TextInput style={styles.textInputUpdateDialog} placeholder='id' onChangeText={(Text) =>setData.id(Text)}/>
//             <TextInput style={styles.textInputUpdateDialog} placeholder='title' onChangeText={(Text) =>setData.title(Text)}/>
//             <TextInput style={styles.textInputUpdateDialog} placeholder='description' onChangeText={(Text) =>setData.description(Text)}/>
//             <TextInput style={styles.textInputUpdateDialog} placeholder='price' onChangeText={(Text) =>setData.price(Text)}/>
//             <TouchableOpacity style={styles.selectImage}>
//               <Text>Select Image</Text>
//             </TouchableOpacity>
//             <View style={{flex : 1, flexDirection : 'row' ,alignItems : 'flex-end',marginLeft : 200}}>
//               <Button title="NO" onPress={toggleModal} />
//               <Button title='YES' onPress={()=>{
//                 toggleModal();
//               }} />
//             </View>
            
//           </View>
//         </Modal>
//     </View>
//   )
// }

// function Chitiet({route}){
//   const app = initializeApp(firebaseConfig);
//   const {id, title, description, price , images} = route.params;
//   const item = {
//     id : id,
//     title : title,
//     description : description,
//     price : price,
//     images : images
//   }
  
//   return(
//     <View>
//         <Text>{id}</Text>
//         <Text>{title}</Text>
//         <Text>{description}</Text>
//         <Text>{price}</Text>
//         <Image source={{uri : images}} style={{width : 50 , height : 50}}/>
//         <Button title={'dong bo'} onPress={()=>{
//             const db = getDatabase();
//             set(ref(db,'products/' + item.id),item).then(
//               r =>{
//                 if(r != null){
//                   alert('thanh cong');
//                 }
//               }
//             )
//         }}/>
//         <Button title={'xoa'} onPress={()=>{
//             const db = getDatabase();
//             remove(ref(db,'/products/'+ item.id))
//         }}/>
//     </View>
//   )
// }


      // lab1 AndroidNetWorking 

export default function App() {
  // const Stack = createNativeStackNavigator();

  const [data,setData] = useState([]);
  useEffect( () =>{
    var requestOptions = {
      method: 'GET',
      redirect: 'follow'
    };
    
    fetch("https://jsonplaceholder.typicode.com/photos", requestOptions)
      .then(response => response.json())
      .then(result => setData(result))
      .catch(error => console.log('error', error));
  } ,
  [])
  return (
    // <NavigationContainer>
    //   <Stack.Navigator>
    //     <Stack.Screen name='Chao' component={Chao}/>
    //     <Stack.Screen name='Chinh' component={Chinh}/>
    //     <Stack.Screen name='Chitiet' component={Chitiet}/>

    //   </Stack.Navigator>
    // </NavigationContainer>

      <View style={styles.container}>
        <FlatList
          data={data}
          renderItem={({item}) =>{
            return(
              <View style={{  alignItems : 'center'}}>
                  <View style={styles.viewCard}>
                    <View style={{ flexDirection : 'row' }}>
                    {/* <Image source={{uri : item.thumbnailUrl}} style={{ width : 40 , height : 40}}/> */}
                    <Image source={{uri : item.url}} style={{ width : 60 , height : 60 , borderRadius : 30}}/>

                    </View>
                    <View style={{ paddingLeft : 10}}>
                    <Text>{item.id}</Text>
                    <Text>{item.albumId}</Text>
                    <Text>{item.title}</Text>
                    </View>
                  </View>

              </View>
            )
          }}
        />
      </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    // backgroundColor: '#fff',
    // alignItems: 'center',
    // justifyContent: 'center',
    marginTop : 50
  }, 
  viewCard:{
    width : 380,
    height : 80,
    flexDirection : 'row',
    borderWidth : 1,
    alignItems : 'center',
    marginTop : 10
  }
});
