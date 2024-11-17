import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import ProductPage from '@/views/ProductPage.vue';
import ProviderPage from '@/views/ProviderPage.vue';
import CategoriaPage from '@/views/CategoriaPage.vue';

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
  path: '/productos',
  name: 'Productos',
  component: ProductPage
},

{
  path: '/proveedores',
  name: 'Proveedores',
  component: ProviderPage
}, 
{
  path: '/categoria',
  name: 'categoria',
  component: CategoriaPage
}


]


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
