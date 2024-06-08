<template>
  <div class="atm-container">
    <header>
      <span class="welcome-message">Welcome, {{ email }}</span>
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
    const email = localStorage.getItem('email');  // Get email from localStorage
    const currentDateTime = ref('');
    const action = ref('');
    const amount = ref(0);
    const balance = ref(0);  // Initial balance set to 0
    const token = localStorage.getItem('token');  // Get token from localStorage

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
        let response;
        if (action.value === 'withdraw') {
          if (amount.value > balance.value) {
            alert('Insufficient balance.');
            return;
          } else {
            response = await axios.post(
                'http://localhost:4000/withdraw',
                { amount: amount.value },
                { headers: { Authorization: `Bearer ${token}` } }
            );
          }
        } else if (action.value === 'deposit') {
          response = await axios.post(
              'http://localhost:4000/deposit',
              { amount: amount.value },
              { headers: { Authorization: `Bearer ${token}` } }
          );
        }
        balance.value = response.data.balance;
        alert(`Successfully ${action.value}ed ${amount.value} units.`);
      } catch (error) {
        console.error(error);
        alert('An error occurred while performing the action.');
      }

      amount.value = 0;  // Reset amount after action
      action.value = '';  // Reset action after performing it
    };

    const fetchBalance = async () => {
      try {
        const response = await axios.get('http://localhost:4000/balance', {
          headers: { Authorization: `Bearer ${token}` }
        });
        balance.value = response.data.balance;
      } catch (error) {
        console.error('Error fetching balance:', error);
      }
    };

    onMounted(async () => {
      updateDateTime();
      setInterval(updateDateTime, 1000);  // Update every second
      await fetchBalance();
    });

    return {
      email,
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

