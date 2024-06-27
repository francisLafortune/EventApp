import OpenAPIClientAxios from 'openapi-client-axios';

const api = new OpenAPIClientAxios({definition: 'http://localhost/api/api-docs'});
api.init();

export async function getEvents() {
    const client = await api.getClient();
    return await client.getEvents();
}