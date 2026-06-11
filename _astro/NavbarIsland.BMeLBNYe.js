import{j as e}from"./jsx-runtime.D_zvdyIk.js";import{r as l}from"./index.CdJzaNS0.js";/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const x=t=>t.replace(/([a-z0-9])([A-Z])/g,"$1-$2").toLowerCase(),h=(...t)=>t.filter((a,n,r)=>!!a&&a.trim()!==""&&r.indexOf(a)===n).join(" ").trim();/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */var p={xmlns:"http://www.w3.org/2000/svg",width:24,height:24,viewBox:"0 0 24 24",fill:"none",stroke:"currentColor",strokeWidth:2,strokeLinecap:"round",strokeLinejoin:"round"};/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const k=l.forwardRef(({color:t="currentColor",size:a=24,strokeWidth:n=2,absoluteStrokeWidth:r,className:o="",children:s,iconNode:d,...m},u)=>l.createElement("svg",{ref:u,...p,width:a,height:a,stroke:t,strokeWidth:r?Number(n)*24/Number(a):n,className:h("lucide",o),...m},[...d.map(([f,g])=>l.createElement(f,g)),...Array.isArray(s)?s:[s]]));/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const c=(t,a)=>{const n=l.forwardRef(({className:r,...o},s)=>l.createElement(k,{ref:s,iconNode:a,className:h(`lucide-${x(t)}`,r),...o}));return n.displayName=`${t}`,n};/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const b=c("Github",[["path",{d:"M15 22v-4a4.8 4.8 0 0 0-1-3.5c3 0 6-2 6-5.5.08-1.25-.27-2.48-1-3.5.28-1.15.28-2.35 0-3.5 0 0-1 0-3 1.5-2.64-.5-5.36-.5-8 0C6 2 5 2 5 2c-.3 1.15-.3 2.35 0 3.5A5.403 5.403 0 0 0 4 9c0 3.5 3 5.5 6 5.5-.39.49-.68 1.05-.85 1.65-.17.6-.22 1.23-.15 1.85v4",key:"tonef"}],["path",{d:"M9 18c-4.51 2-5-2-7-2",key:"9comsn"}]]);/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const j=c("Moon",[["path",{d:"M12 3a6 6 0 0 0 9 9 9 9 0 1 1-9-9Z",key:"a7tn18"}]]);/**
 * @license lucide-react v0.469.0 - ISC
 *
 * This source code is licensed under the ISC license.
 * See the LICENSE file in the root directory of this source tree.
 */const y=c("Sun",[["circle",{cx:"12",cy:"12",r:"4",key:"4exip2"}],["path",{d:"M12 2v2",key:"tus03m"}],["path",{d:"M12 20v2",key:"1lh1kg"}],["path",{d:"m4.93 4.93 1.41 1.41",key:"149t6j"}],["path",{d:"m17.66 17.66 1.41 1.41",key:"ptbguv"}],["path",{d:"M2 12h2",key:"1t8f8n"}],["path",{d:"M20 12h2",key:"1q8mjw"}],["path",{d:"m6.34 17.66-1.41 1.41",key:"1m8zz5"}],["path",{d:"m19.07 4.93-1.41 1.41",key:"1shlcs"}]]);function v(){if(typeof window>"u")return"dark";const t=localStorage.getItem("theme");return t||(window.matchMedia("(prefers-color-scheme: dark)").matches?"dark":"light")}function w(){const[t,a]=l.useState("dark");l.useEffect(()=>{const r=v();a(r),document.documentElement.setAttribute("data-theme",r)},[]);function n(){const r=t==="dark"?"light":"dark";a(r),document.documentElement.setAttribute("data-theme",r),localStorage.setItem("theme",r)}return e.jsx("button",{className:"theme-toggle",onClick:n,"aria-label":`Switch to ${t==="dark"?"light":"dark"} mode`,children:t==="dark"?e.jsx(y,{size:13}):e.jsx(j,{size:13})})}const N=[{label:"projects",href:"#projects"},{label:"about",href:"#about"},{label:"resume",href:"#resume"},{label:"contact",href:"#contact"}],I=[{label:"Features",href:"#features"},{label:"Installation",href:"#installation"},{label:"Docs",href:"#docs"},{label:"Changelog",href:"#changelog"}];function M(t){const a=t.links??(t.kind==="homepage"?N:I);return e.jsxs("nav",{className:"navbar",style:{position:"sticky",top:0,zIndex:100},children:[e.jsx("div",{className:"navbar-brand",children:e.jsxs("a",{href:"/",style:{display:"flex",alignItems:"center",gap:"8px",textDecoration:"none"},children:[t.icon&&e.jsx("span",{style:{display:"flex",alignItems:"center",flexShrink:0},children:t.icon}),t.kind==="homepage"?!t.icon&&e.jsx("span",{style:{fontFamily:"var(--font-mono)",fontWeight:700,fontSize:"15px",color:"var(--accent)"},children:"yk"}):e.jsxs(e.Fragment,{children:[e.jsx("span",{style:{fontFamily:"var(--font-mono)",fontWeight:700,fontSize:"14px",color:"var(--text-primary)"},children:t.productName}),e.jsx("span",{className:"navbar-domain",children:".koellmann.dev"})]})]})}),e.jsx("div",{className:"navbar-links",children:a.map(n=>e.jsx("a",{href:n.href,className:"navbar-link",children:n.label},n.href))}),e.jsxs("div",{style:{display:"flex",alignItems:"center",gap:"8px"},children:[e.jsx(w,{}),t.kind==="homepage"?e.jsx("a",{href:"https://github.com/ykoellmann",target:"_blank",rel:"noopener noreferrer",className:"btn-icon","aria-label":"GitHub",children:e.jsx(b,{size:14})}):e.jsx("a",{href:t.installHref??"#installation",className:"btn btn-primary btn-sm",children:"Install"})]})]})}function C({productName:t,icon:a,installHref:n,githubUrl:r}){const o=[{label:"Features",href:"#features"},{label:"Installation",href:"#installation"},{label:"Docs",href:r},{label:"Changelog",href:"#changelog"}];return e.jsx(M,{kind:"product",productName:t,icon:a,installHref:n,links:o})}const i={name:"Shortplate",githubUrl:"https://github.com/ykoellmann/shortplate",marketplaceUrl:"https://plugins.jetbrains.com/plugin/shortplate"},L=e.jsxs("svg",{width:"22",height:"22",viewBox:"0 0 40 40",fill:"none",xmlns:"http://www.w3.org/2000/svg",children:[e.jsx("rect",{width:"40",height:"40",rx:"8",fill:"#1E1F22"}),e.jsx("rect",{x:"5",y:"9",width:"20",height:"3",rx:"1.5",fill:"#6897BB"}),e.jsx("rect",{x:"5",y:"15",width:"13",height:"3",rx:"1.5",fill:"#6897BB"}),e.jsx("rect",{x:"5",y:"21",width:"17",height:"3",rx:"1.5",fill:"#6897BB"}),e.jsx("rect",{x:"22",y:"22",width:"14",height:"13",rx:"3",fill:"#d4954a"}),e.jsx("path",{d:"M26 28.5 H33",stroke:"white",strokeWidth:"2",strokeLinecap:"round"}),e.jsx("path",{d:"M30 25 L33 28.5 L30 32",stroke:"white",strokeWidth:"2",fill:"none",strokeLinecap:"round",strokeLinejoin:"round"})]});function E(){return e.jsx(C,{productName:i.name,icon:L,installHref:i.marketplaceUrl,githubUrl:i.githubUrl})}export{E as default};
