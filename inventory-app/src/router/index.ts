import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import ProductPage from '@/views/ProductPage.vue';
import ProviderPage from '@/views/ProviderPage.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },

{
  path: '/producto',
  name: 'Producto',
  component: ProductPage
},

{
  path: '/proveedores',
  name: 'Proveedores',
  component: ProviderPage
}

]


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
