<template>
  <div class="atm-container">
    <header>
      <span class="welcome-message">Welcome, {{ userName }}</span>
      <span class="date-time">{{ currentDateTime }}</span>
    </header>
    <main>
      <div class="balance">
        Current Balance: {{ balance }} units
      </div>
      <div class="atm-actions">
        <button @click="setAction('withdraw')">Withdraw</button>
        <button @click="setAction('deposit')">Deposit</button>
      </div>
      <div v-if="action">
        <h3>{{ action.charAt(0).toUpperCase() + action.slice(1) }} Money</h3>
        <input type="number" v-model="amount" placeholder="Enter amount" />
        <button @click="performAction">{{ action }}</button>
      </div>
    </main>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';

export default {
  name: 'ATM',
  setup() {
    const userName = 'User';  // Replace with actual user name if available
    const currentDateTime = ref('');
    const action = ref('');
    const amount = ref(0);
    const balance = ref(0);  // Initial balance set to 0
    const token = ref('');

    const updateDateTime = () => {
      const now = new Date();
      currentDateTime.value = now.toLocaleString();
    };

    const setAction = (selectedAction) => {
      action.value = selectedAction;
      amount.value = 0;  // Reset amount when action changes
    };

    const performAction = async () => {
      if (amount.value <= 0) {
        alert('Please enter a valid amount.');
        return;
      }

      try {
        if (action.value === 'withdraw') {
          if (amount.value > balance.value) {
            alert('Insufficient balance.');
          } else {
            const response = await axios.post(
                'https://api.example.com/withdraw',
                { amount: amount.value },
                { headers: { Authorization: `Bearer ${token.value}` } }
            );
            balance.value = response.data.balance;
            alert(`Successfully withdrew ${amount.value} units.`);
          }
        } else if (action.value === 'deposit') {
          const response = await axios.post(
              'https://api.example.com/deposit',
              { amount: amount.value },
              { headers: { Authorization: `Bearer ${token.value}` } }
          );
          balance.value = response.data.balance;
          alert(`Successfully deposited ${amount.value} units.`);
        }
      } catch (error) {
        console.error(error);
        alert('An error occurred while performing the action.');
      }

      amount.value = 0;  // Reset amount after action
      action.value = '';  // Reset action after performing it
    };

    const fetchToken = async () => {
      try {
        const response = await axios.post('https://api.example.com/authenticate', {
          username: 'your-username',  // Replace with actual username
          password: 'your-password'   // Replace with actual password
        });
        token.value = response.data.token;
      } catch (error) {
        console.error('Error fetching token:', error);
      }
    };

    const fetchBalance = async () => {
      try {
        const response = await axios.get('https://api.example.com/balance', {
          headers: { Authorization: `Bearer ${token.value}` }
        });
        balance.value = response.data.balance;
      } catch (error) {
        console.error('Error fetching balance:', error);
      }
    };

    onMounted(async () => {
      updateDateTime();
      setInterval(updateDateTime, 1000);  // Update every second
      await fetchToken();
      await fetchBalance();
    });

    return {
      userName,
      currentDateTime,
      action,
      amount,
      balance,
      setAction,
      performAction,
    };
  },
};
</script>

<style scoped>
@import '../style.css';
</style>
