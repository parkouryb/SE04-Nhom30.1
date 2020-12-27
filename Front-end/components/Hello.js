import React, {Component} from 'react';
import {
    AppRegistry,
    Text,
    View,
    Button,
    StyleSheet,
    Platform,
    TouchableOpacity,
    Dimensions,
    TextInput
} from 'react-native';

//import FontAwesome from 'react-native-vector-icons/FontAwesome'
//import Feather from 'react-native-vector-icons/Feather';

const Hello = () => {
    
    const [data, setData] = React.useState({
        email: '',
        password: '',
        check_textInputChange: false,
        secureTextEntry: true
    });

    const textInputChange = (val) => {
        if(val.length !== 0){
            setData({
                ...data,
                email: val,
                check_textInputChange: true
            });
        }
        else{
            setData({
                ...data,
                email: val,
                check_textInputChange: false
            });
        }
    }

    return(
        <View style={styles.container}>
            <View style={styles.header}>
                <Text style={styles.text_header}>Welcome!</Text>
            </View>
            <View style={styles.footer}>
                <Text style={styles.text_footer}>Email</Text>
                <View style={styles.action}>
                    {/* <FontAwesome
                        name="user-o"
                        color="#05375a"
                        size={20}
                    /> */}
                    <TextInput
                        placeholder="Your Email"
                        style={styles.TextInput}
                        autoCapitalize="none"
                        onChangeText={(val) => textInputChange(val)}
                    />
                    {data.check_textInputChange}
                </View>

                <Text style={[styles.text_footer,
                {marginTop: 20}]}>
                Password
                </Text>
                <TextInput
                        placeholder="Your Password"
                        secureTextEntry={true}
                        style={styles.TextInput}
                        autoCapitalize="none"
                    />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#009387'
    },
    header:{
        flex:1,
        justifyContent: 'flex-end',
        paddingHorizontal: 20,
        paddingBottom: 50
    },
    footer: {
        flex: 3,
        backgroundColor: '#fff',
        borderTopLeftRadius: 30,
        borderTopRightRadius: 30,
        paddingHorizontal: 20,
        paddingVertical: 30
    },
    action: {
        flexDirection: 'row',
        marginTop: 10,
        borderBottomWidth: 1,
        borderBottomColor: '#f2f2f2',
        paddingBottom: 5
    },
    text_header: {
        color: '#fff',
        fontWeight: 'bold',
        fontSize: 30
    },
    text_footer: {
        color: '#05375a',
        fontSize: 18
    },
    button: {
        alignItems: 'center',
        marginTop: 50
    },
    signIn: {
        width: '100%',
        height: 50,
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 10
    },
    textSign: {
        fontSize: 18,
        fontWeight: 'bold'
    },
    textInput: {
        flex: 1,
        //margin: Platform.OS === 'android' ? 0 : -12,
        paddingLeft: 10,
        color: '#05375a'
    }
})
export default Hello;