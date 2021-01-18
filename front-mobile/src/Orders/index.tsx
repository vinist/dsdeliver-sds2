import React from 'react';
import { StyleSheet, Text, View} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';
import Header from '../Header';
import OrderCard from '../OrderCard';

export default function Orders() {

    return (
      <>
        <Header />
        <ScrollView style={styles.container}>
          <OrderCard />
        </ScrollView>
      </>
    );
  }
  
  const styles = StyleSheet.create({
    container: {
      paddingRight: '5%',
      paddingLeft: '5%'
  }
  });