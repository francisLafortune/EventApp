<script setup>
import {format} from "@/utils/DateFormatter.js"

const props = defineProps(['events'])
</script>

<template>
  <ul class="list-group">
    <li v-for="event in events" class="list-group-item d-flex justify-content-between">
      <div>
        {{ event.name }}
        <br>
        <span class="form-text">{{ format(event.beginTimestamp) }}</span>
      </div>
      <div class="d-flex justify-content-center">
        <button class="btn btn-primary">Détails</button>
      </div>
    </li>
  </ul>
</template>