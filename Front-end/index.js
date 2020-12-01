/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import Hello from './components/Hello'

AppRegistry.registerComponent(appName, () => Hello);
