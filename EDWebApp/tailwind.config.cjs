/** @type {import('tailwindcss').Config} */
module.exports = {
    darkMode: 'class',
    content: ['./src/**/*.{html,js,svelte,ts}'],
    theme: {
        extend: {
            colors: {
                'primary-50': "#FFFAF0",
                'primary-100': "#FEEBC8",
                'primary-200': "#FBD38D",
                'primary-300': "#F6AD55",
                'primary-400': "#ED8936",
                'primary-500': "#DD6B20",
                'primary-600': "#C05621",
                'primary-700': "#9e4322",
                'primary-800': "#903c23",
                'primary-900': "#78321d",

                'gray-50': '#F7FAFC',
                'gray-100': '#EDF2F7',
                'gray-200': '#E2E8F0',
                'gray-300': '#CBD5E0',
                'gray-400': '#A0AEC0',
                'gray-500': '#718096',
                'gray-600': '#4a555a',
                'gray-700': '#2d373c',
                'gray-800': '#1a2024',
                'gray-900': '#17191e',
            }
        }
    },
    plugins: [],
}
