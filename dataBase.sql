PGDMP         :                |           Piquera_de_Taxis    15.3    15.3 E    M           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            N           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            O           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            P           1262    16451    Piquera_de_Taxis    DATABASE     �   CREATE DATABASE "Piquera_de_Taxis" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
 "   DROP DATABASE "Piquera_de_Taxis";
                postgres    false                        3079    16452 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            Q           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16640    centros_turisticos    TABLE        CREATE TABLE public.centros_turisticos (
    id_centro integer NOT NULL,
    nombre_centro text,
    tiene_contrato boolean
);
 &   DROP TABLE public.centros_turisticos;
       public         heap    postgres    false            �            1259    16639     centros_turisticos_id_centro_seq    SEQUENCE     �   CREATE SEQUENCE public.centros_turisticos_id_centro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.centros_turisticos_id_centro_seq;
       public          postgres    false    217            R           0    0     centros_turisticos_id_centro_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.centros_turisticos_id_centro_seq OWNED BY public.centros_turisticos.id_centro;
          public          postgres    false    216            �            1259    16654    facturas    TABLE     v   CREATE TABLE public.facturas (
    id_factura integer NOT NULL,
    precio real,
    id_servicio_culminado integer
);
    DROP TABLE public.facturas;
       public         heap    postgres    false            �            1259    16653    facturas_id_factura_seq    SEQUENCE     �   CREATE SEQUENCE public.facturas_id_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.facturas_id_factura_seq;
       public          postgres    false    219            S           0    0    facturas_id_factura_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.facturas_id_factura_seq OWNED BY public.facturas.id_factura;
          public          postgres    false    218            �            1259    16694    servicios_en_ejecucion    TABLE     �   CREATE TABLE public.servicios_en_ejecucion (
    id_solicitud integer NOT NULL,
    id_centro integer,
    direccion text,
    destino text,
    hora_recogida time without time zone,
    cant_personas integer,
    cant_km real,
    id_taxi text
);
 *   DROP TABLE public.servicios_en_ejecucion;
       public         heap    postgres    false            �            1259    16736 &   servcios_en_ejecucion_id_solicitud_seq    SEQUENCE     �   CREATE SEQUENCE public.servcios_en_ejecucion_id_solicitud_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.servcios_en_ejecucion_id_solicitud_seq;
       public          postgres    false    225            T           0    0 &   servcios_en_ejecucion_id_solicitud_seq    SEQUENCE OWNED BY     r   ALTER SEQUENCE public.servcios_en_ejecucion_id_solicitud_seq OWNED BY public.servicios_en_ejecucion.id_solicitud;
          public          postgres    false    228            �            1259    16708    servicios_culminados    TABLE     *  CREATE TABLE public.servicios_culminados (
    id_solicitud integer NOT NULL,
    id_centro integer,
    direccion text,
    destino text,
    hora_recogida time without time zone,
    cant_pesonas integer,
    cant_km real,
    id_taxi text,
    hora_fin time without time zone,
    fecha date
);
 (   DROP TABLE public.servicios_culminados;
       public         heap    postgres    false            �            1259    16707 %   servicios_culminados_id_solicitud_seq    SEQUENCE     �   CREATE SEQUENCE public.servicios_culminados_id_solicitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.servicios_culminados_id_solicitud_seq;
       public          postgres    false    227            U           0    0 %   servicios_culminados_id_solicitud_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.servicios_culminados_id_solicitud_seq OWNED BY public.servicios_culminados.id_solicitud;
          public          postgres    false    226            �            1259    16693 '   servicios_en ejecucion_id_solicitud_seq    SEQUENCE     �   CREATE SEQUENCE public."servicios_en ejecucion_id_solicitud_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public."servicios_en ejecucion_id_solicitud_seq";
       public          postgres    false    225            V           0    0 '   servicios_en ejecucion_id_solicitud_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public."servicios_en ejecucion_id_solicitud_seq" OWNED BY public.servicios_en_ejecucion.id_solicitud;
          public          postgres    false    224            �            1259    16680    servicios_inmediatos    TABLE     �   CREATE TABLE public.servicios_inmediatos (
    id_solicitud integer NOT NULL,
    id_centro integer,
    destino text,
    direccion text,
    hora_recogida time without time zone,
    cant_personas integer,
    cant_km numeric
);
 (   DROP TABLE public.servicios_inmediatos;
       public         heap    postgres    false            �            1259    16679 %   servicios_inmediatos_id_solicitud_seq    SEQUENCE     �   CREATE SEQUENCE public.servicios_inmediatos_id_solicitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.servicios_inmediatos_id_solicitud_seq;
       public          postgres    false    223            W           0    0 %   servicios_inmediatos_id_solicitud_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.servicios_inmediatos_id_solicitud_seq OWNED BY public.servicios_inmediatos.id_solicitud;
          public          postgres    false    222            �            1259    16666    solicitudes    TABLE     �   CREATE TABLE public.solicitudes (
    id_solicitud integer NOT NULL,
    id_centro integer,
    direccion text,
    destino text,
    hora_recogida time without time zone,
    cant_km real,
    cant_personas integer
);
    DROP TABLE public.solicitudes;
       public         heap    postgres    false            �            1259    16665    solicitudes2_id_solicitud_seq    SEQUENCE     �   CREATE SEQUENCE public.solicitudes2_id_solicitud_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.solicitudes2_id_solicitud_seq;
       public          postgres    false    221            X           0    0    solicitudes2_id_solicitud_seq    SEQUENCE OWNED BY     ^   ALTER SEQUENCE public.solicitudes2_id_solicitud_seq OWNED BY public.solicitudes.id_solicitud;
          public          postgres    false    220            �            1259    16738    taxi_estatal    TABLE     S   CREATE TABLE public.taxi_estatal (
    id_chapa text NOT NULL,
    empresa text
);
     DROP TABLE public.taxi_estatal;
       public         heap    postgres    false            �            1259    16750    taxi_particular    TABLE     Y   CREATE TABLE public.taxi_particular (
    id_chapa text NOT NULL,
    no_patente text
);
 #   DROP TABLE public.taxi_particular;
       public         heap    postgres    false            �            1259    16472    taxis    TABLE     �   CREATE TABLE public.taxis (
    id_chapa text NOT NULL,
    estado text,
    marca text,
    capacidad integer,
    id_chofer integer,
    cant_combustible numeric,
    tipo text
);
    DROP TABLE public.taxis;
       public         heap    postgres    false            �           2604    16643    centros_turisticos id_centro    DEFAULT     �   ALTER TABLE ONLY public.centros_turisticos ALTER COLUMN id_centro SET DEFAULT nextval('public.centros_turisticos_id_centro_seq'::regclass);
 K   ALTER TABLE public.centros_turisticos ALTER COLUMN id_centro DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    16657    facturas id_factura    DEFAULT     z   ALTER TABLE ONLY public.facturas ALTER COLUMN id_factura SET DEFAULT nextval('public.facturas_id_factura_seq'::regclass);
 B   ALTER TABLE public.facturas ALTER COLUMN id_factura DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    16711 !   servicios_culminados id_solicitud    DEFAULT     �   ALTER TABLE ONLY public.servicios_culminados ALTER COLUMN id_solicitud SET DEFAULT nextval('public.servicios_culminados_id_solicitud_seq'::regclass);
 P   ALTER TABLE public.servicios_culminados ALTER COLUMN id_solicitud DROP DEFAULT;
       public          postgres    false    227    226    227            �           2604    16737 #   servicios_en_ejecucion id_solicitud    DEFAULT     �   ALTER TABLE ONLY public.servicios_en_ejecucion ALTER COLUMN id_solicitud SET DEFAULT nextval('public.servcios_en_ejecucion_id_solicitud_seq'::regclass);
 R   ALTER TABLE public.servicios_en_ejecucion ALTER COLUMN id_solicitud DROP DEFAULT;
       public          postgres    false    228    225            �           2604    16683 !   servicios_inmediatos id_solicitud    DEFAULT     �   ALTER TABLE ONLY public.servicios_inmediatos ALTER COLUMN id_solicitud SET DEFAULT nextval('public.servicios_inmediatos_id_solicitud_seq'::regclass);
 P   ALTER TABLE public.servicios_inmediatos ALTER COLUMN id_solicitud DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    16669    solicitudes id_solicitud    DEFAULT     �   ALTER TABLE ONLY public.solicitudes ALTER COLUMN id_solicitud SET DEFAULT nextval('public.solicitudes2_id_solicitud_seq'::regclass);
 G   ALTER TABLE public.solicitudes ALTER COLUMN id_solicitud DROP DEFAULT;
       public          postgres    false    220    221    221            =          0    16640    centros_turisticos 
   TABLE DATA           V   COPY public.centros_turisticos (id_centro, nombre_centro, tiene_contrato) FROM stdin;
    public          postgres    false    217   �W       ?          0    16654    facturas 
   TABLE DATA           M   COPY public.facturas (id_factura, precio, id_servicio_culminado) FROM stdin;
    public          postgres    false    219   X       G          0    16708    servicios_culminados 
   TABLE DATA           �   COPY public.servicios_culminados (id_solicitud, id_centro, direccion, destino, hora_recogida, cant_pesonas, cant_km, id_taxi, hora_fin, fecha) FROM stdin;
    public          postgres    false    227   7X       E          0    16694    servicios_en_ejecucion 
   TABLE DATA           �   COPY public.servicios_en_ejecucion (id_solicitud, id_centro, direccion, destino, hora_recogida, cant_personas, cant_km, id_taxi) FROM stdin;
    public          postgres    false    225   �X       C          0    16680    servicios_inmediatos 
   TABLE DATA           �   COPY public.servicios_inmediatos (id_solicitud, id_centro, destino, direccion, hora_recogida, cant_personas, cant_km) FROM stdin;
    public          postgres    false    223   �X       A          0    16666    solicitudes 
   TABLE DATA           y   COPY public.solicitudes (id_solicitud, id_centro, direccion, destino, hora_recogida, cant_km, cant_personas) FROM stdin;
    public          postgres    false    221    Y       I          0    16738    taxi_estatal 
   TABLE DATA           9   COPY public.taxi_estatal (id_chapa, empresa) FROM stdin;
    public          postgres    false    229   ^Y       J          0    16750    taxi_particular 
   TABLE DATA           ?   COPY public.taxi_particular (id_chapa, no_patente) FROM stdin;
    public          postgres    false    230   {Y       ;          0    16472    taxis 
   TABLE DATA           f   COPY public.taxis (id_chapa, estado, marca, capacidad, id_chofer, cant_combustible, tipo) FROM stdin;
    public          postgres    false    215   �Y       Y           0    0     centros_turisticos_id_centro_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.centros_turisticos_id_centro_seq', 3, true);
          public          postgres    false    216            Z           0    0    facturas_id_factura_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.facturas_id_factura_seq', 1, true);
          public          postgres    false    218            [           0    0 &   servcios_en_ejecucion_id_solicitud_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.servcios_en_ejecucion_id_solicitud_seq', 1, false);
          public          postgres    false    228            \           0    0 %   servicios_culminados_id_solicitud_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.servicios_culminados_id_solicitud_seq', 1, true);
          public          postgres    false    226            ]           0    0 '   servicios_en ejecucion_id_solicitud_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public."servicios_en ejecucion_id_solicitud_seq"', 1, false);
          public          postgres    false    224            ^           0    0 %   servicios_inmediatos_id_solicitud_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public.servicios_inmediatos_id_solicitud_seq', 1, false);
          public          postgres    false    222            _           0    0    solicitudes2_id_solicitud_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.solicitudes2_id_solicitud_seq', 12, true);
          public          postgres    false    220            �           2606    16500    taxis Taxis Estatales_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.taxis
    ADD CONSTRAINT "Taxis Estatales_pkey" PRIMARY KEY (id_chapa);
 F   ALTER TABLE ONLY public.taxis DROP CONSTRAINT "Taxis Estatales_pkey";
       public            postgres    false    215            �           2606    16647 *   centros_turisticos centros_turisticos_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.centros_turisticos
    ADD CONSTRAINT centros_turisticos_pkey PRIMARY KEY (id_centro);
 T   ALTER TABLE ONLY public.centros_turisticos DROP CONSTRAINT centros_turisticos_pkey;
       public            postgres    false    217            �           2606    16659    facturas facturas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT facturas_pkey PRIMARY KEY (id_factura);
 @   ALTER TABLE ONLY public.facturas DROP CONSTRAINT facturas_pkey;
       public            postgres    false    219            �           2606    16715 .   servicios_culminados servicios_culminados_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.servicios_culminados
    ADD CONSTRAINT servicios_culminados_pkey PRIMARY KEY (id_solicitud);
 X   ALTER TABLE ONLY public.servicios_culminados DROP CONSTRAINT servicios_culminados_pkey;
       public            postgres    false    227            �           2606    16701 2   servicios_en_ejecucion servicios_en ejecucion_pkey 
   CONSTRAINT     |   ALTER TABLE ONLY public.servicios_en_ejecucion
    ADD CONSTRAINT "servicios_en ejecucion_pkey" PRIMARY KEY (id_solicitud);
 ^   ALTER TABLE ONLY public.servicios_en_ejecucion DROP CONSTRAINT "servicios_en ejecucion_pkey";
       public            postgres    false    225            �           2606    16687 .   servicios_inmediatos servicios_inmediatos_pkey 
   CONSTRAINT     v   ALTER TABLE ONLY public.servicios_inmediatos
    ADD CONSTRAINT servicios_inmediatos_pkey PRIMARY KEY (id_solicitud);
 X   ALTER TABLE ONLY public.servicios_inmediatos DROP CONSTRAINT servicios_inmediatos_pkey;
       public            postgres    false    223            �           2606    16673    solicitudes solicitudes2_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT solicitudes2_pkey PRIMARY KEY (id_solicitud);
 G   ALTER TABLE ONLY public.solicitudes DROP CONSTRAINT solicitudes2_pkey;
       public            postgres    false    221            �           2606    16744    taxi_estatal taxi_estatal_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.taxi_estatal
    ADD CONSTRAINT taxi_estatal_pkey PRIMARY KEY (id_chapa);
 H   ALTER TABLE ONLY public.taxi_estatal DROP CONSTRAINT taxi_estatal_pkey;
       public            postgres    false    229            �           2606    16756 $   taxi_particular taxi_particular_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.taxi_particular
    ADD CONSTRAINT taxi_particular_pkey PRIMARY KEY (id_chapa);
 N   ALTER TABLE ONLY public.taxi_particular DROP CONSTRAINT taxi_particular_pkey;
       public            postgres    false    230            �           2606    16731 #   facturas factura_servicio_culminado    FK CONSTRAINT     �   ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT factura_servicio_culminado FOREIGN KEY (id_servicio_culminado) REFERENCES public.servicios_culminados(id_solicitud) NOT VALID;
 M   ALTER TABLE ONLY public.facturas DROP CONSTRAINT factura_servicio_culminado;
       public          postgres    false    227    219    3231            �           2606    16688 .   servicios_inmediatos servicio_inmediato_dentro    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios_inmediatos
    ADD CONSTRAINT servicio_inmediato_dentro FOREIGN KEY (id_centro) REFERENCES public.centros_turisticos(id_centro);
 X   ALTER TABLE ONLY public.servicios_inmediatos DROP CONSTRAINT servicio_inmediato_dentro;
       public          postgres    false    3221    217    223            �           2606    16716 0   servicios_culminados servicios_culminados_centro    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios_culminados
    ADD CONSTRAINT servicios_culminados_centro FOREIGN KEY (id_centro) REFERENCES public.centros_turisticos(id_centro);
 Z   ALTER TABLE ONLY public.servicios_culminados DROP CONSTRAINT servicios_culminados_centro;
       public          postgres    false    227    3221    217            �           2606    16726 .   servicios_culminados servicios_culminados_taxi    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios_culminados
    ADD CONSTRAINT servicios_culminados_taxi FOREIGN KEY (id_taxi) REFERENCES public.taxis(id_chapa) NOT VALID;
 X   ALTER TABLE ONLY public.servicios_culminados DROP CONSTRAINT servicios_culminados_taxi;
       public          postgres    false    227    3219    215            �           2606    16702 4   servicios_en_ejecucion servicios_en ejecucion_centro    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios_en_ejecucion
    ADD CONSTRAINT "servicios_en ejecucion_centro" FOREIGN KEY (id_centro) REFERENCES public.centros_turisticos(id_centro);
 `   ALTER TABLE ONLY public.servicios_en_ejecucion DROP CONSTRAINT "servicios_en ejecucion_centro";
       public          postgres    false    225    3221    217            �           2606    16721 2   servicios_en_ejecucion servicios_en_ejecucion_taxi    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicios_en_ejecucion
    ADD CONSTRAINT servicios_en_ejecucion_taxi FOREIGN KEY (id_taxi) REFERENCES public.taxis(id_chapa) NOT VALID;
 \   ALTER TABLE ONLY public.servicios_en_ejecucion DROP CONSTRAINT servicios_en_ejecucion_taxi;
       public          postgres    false    215    225    3219            �           2606    16674    solicitudes solicitud_centro    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitudes
    ADD CONSTRAINT solicitud_centro FOREIGN KEY (id_centro) REFERENCES public.centros_turisticos(id_centro) ON UPDATE CASCADE ON DELETE SET NULL NOT VALID;
 F   ALTER TABLE ONLY public.solicitudes DROP CONSTRAINT solicitud_centro;
       public          postgres    false    217    3221    221            �           2606    16745    taxi_estatal taxi_estatal_taxi    FK CONSTRAINT     �   ALTER TABLE ONLY public.taxi_estatal
    ADD CONSTRAINT taxi_estatal_taxi FOREIGN KEY (id_chapa) REFERENCES public.taxis(id_chapa);
 H   ALTER TABLE ONLY public.taxi_estatal DROP CONSTRAINT taxi_estatal_taxi;
       public          postgres    false    3219    229    215            �           2606    16757 $   taxi_particular taxi_particular_taxi    FK CONSTRAINT     �   ALTER TABLE ONLY public.taxi_particular
    ADD CONSTRAINT taxi_particular_taxi FOREIGN KEY (id_chapa) REFERENCES public.taxis(id_chapa);
 N   ALTER TABLE ONLY public.taxi_particular DROP CONSTRAINT taxi_particular_taxi;
       public          postgres    false    3219    230    215            =   &   x�3�LN�+)�W0�,�2�q��cǘ3�+F��� kx      ?      x�3�41�4����� ;�      G   ?   x�3�4�L�,R ���%@���������Әӈ3���Д���	����s��qqq �S�      E   .   x�3�4�L�,R ���%@���������ӄӈ3���Д+F��� ��	      C   ,   x�34�4�LI-.Q R�E
��V&�V���Fz�\1z\\\ �>w      A   N   x�-ʱ�0C�Z��	r�8.�PBA�8�F�xZ ��5���Qm�FbE518>�?G�p�����TZg%϶3{ �5      I      x������ � �      J      x������ � �      ;   u   x�7004��O.-HL��tOMͩ�4���41�\��f���y
E��E�ə�y�����%�f ef e&��&�9�IE��>�)�9������L.�����$�i� F��� �/"z     