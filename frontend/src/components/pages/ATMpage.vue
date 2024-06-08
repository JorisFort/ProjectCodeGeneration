<template>
  <div class="atm-container">
    <header>
      <span class="welcome-message">Welcome, {{ userName }}</span>
      <span class="date-time">{{ currentDateTime }}</span>
    </header>
    <main>
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

export default {
  name: 'ATM',
  setup() {
    const userName = 'User';  // Replace with actual user name if available
    const currentDateTime = ref('');
    const action = ref('');
    const amount = ref(0);

    const updateDateTime = () => {
      const now = new Date();
      currentDateTime.value = now.toLocaleString();
    };

    const setAction = (selectedAction) => {
      action.value = selectedAction;
    };

    const performAction = () => {
      if (amount.value > 0) {
        alert(`${action.value} ${amount.value} units of money.`);
        // Add logic for performing the action (withdraw/deposit)
      } else {
        alert('Please enter a valid amount.');
      }
    };

    onMounted(() => {
      updateDateTime();
      setInterval(updateDateTime, 1000);  // Update every second
    });

    return {
      userName,
      currentDateTime,
      action,
      amount,
      setAction,
      performAction,
    };
  },
};
</script>
